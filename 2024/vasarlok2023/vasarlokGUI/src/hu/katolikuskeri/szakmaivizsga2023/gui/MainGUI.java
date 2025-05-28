package hu.katolikuskeri.szakmaivizsga2023.gui;

import hu.katolikuskeri.szakmaivizsga2023.cli.Vasarlo;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class MainGUI extends Application {

    private ObservableList<Vasarlo> vasarloObservableList;
    private ListView<Vasarlo> vasarloListView;
    private ComboBox<String> nemComboBox;
    private TextField vasarlasokSzamaField;
    private TextField fizetesiModField;
    private TextField torzsvasarloiKedvezmenyField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vásárlók adatai");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setResizable(false);

        List<Vasarlo> vasarlok = Vasarlo.beolvasas("vasarloi_adatok.csv");
        List<Vasarlo> filteredVasarlok = vasarlok.stream()
                .filter(v -> v.getVasarlasokSzama() >= 40)
                .collect(Collectors.toList());

        vasarloObservableList = FXCollections.observableArrayList(filteredVasarlok);

        vasarloListView = new ListView<>(vasarloObservableList);
        vasarloListView.setPrefWidth(250);

        nemComboBox = new ComboBox<>();
        nemComboBox.getItems().addAll("Nő", "Férfi");
        nemComboBox.setDisable(false);

        vasarlasokSzamaField = new TextField();
        vasarlasokSzamaField.setEditable(false);

        fizetesiModField = new TextField();
        fizetesiModField.setEditable(false);

        torzsvasarloiKedvezmenyField = new TextField();
        torzsvasarloiKedvezmenyField.setEditable(false);

        // Filter list by gender selection
        nemComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) {
                vasarloListView.setItems(vasarloObservableList);
            } else {
                char nemChar = newVal.equals("Nő") ? 'N' : 'F';
                List<Vasarlo> filtered = vasarloObservableList.stream()
                        .filter(v -> v.getNem() == nemChar)
                        .collect(Collectors.toList());
                vasarloListView.setItems(FXCollections.observableArrayList(filtered));
            }
        });

        // Show selected customer details
        vasarloListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                vasarlasokSzamaField.setText(String.valueOf(newVal.getVasarlasokSzama()));
                fizetesiModField.setText(newVal.getFizetesiMod());
                double kedvezmeny = calculateKedvezmeny(newVal.getVasarlasokSzama());
                torzsvasarloiKedvezmenyField.setText(String.format("%.2f%%", kedvezmeny));
            } else {
                vasarlasokSzamaField.clear();
                fizetesiModField.clear();
                torzsvasarloiKedvezmenyField.clear();
            }
        });

        GridPane detailsGrid = new GridPane();
        detailsGrid.setPadding(new Insets(10));
        detailsGrid.setVgap(10);
        detailsGrid.setHgap(10);

        detailsGrid.add(new Label("Vásárlások száma:"), 0, 0);
        detailsGrid.add(vasarlasokSzamaField, 1, 0);

        detailsGrid.add(new Label("Fizetési mód:"), 0, 1);
        detailsGrid.add(fizetesiModField, 1, 1);

        detailsGrid.add(new Label("Törzsvásárlói kedvezmény:"), 0, 2);
        detailsGrid.add(torzsvasarloiKedvezmenyField, 1, 2);

        VBox leftBox = new VBox(10, nemComboBox, vasarloListView);
        leftBox.setPadding(new Insets(10));

        HBox root = new HBox(10, leftBox, detailsGrid);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double calculateKedvezmeny(int vasarlasokSzama) {
        // The formula for discount percentage as per the exam is not explicitly given in the snippet,
        // assuming a sample formula: discount = min(vasarlasokSzama * 0.5, 20)
        // Adjust as needed based on exact formula from exam
        double discount = vasarlasokSzama * 0.5;
        if (discount > 20) {
            discount = 20;
        }
        return discount;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
