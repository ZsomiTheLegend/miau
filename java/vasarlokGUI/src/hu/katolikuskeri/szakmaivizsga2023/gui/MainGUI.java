package hu.katolikuskeri.szakmaivizsga2023.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainGUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("JavaFX GUI sablon – itt lesz a vásárlók kezelése");
        Scene scene = new Scene(new javafx.scene.layout.StackPane(label), 600, 400);
        primaryStage.setTitle("Vásárlók GUI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}