package hu.katolikuskeri.szakmaivizsga2023.cli;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Vasarlo> vasarlok = Vasarlo.beolvasas("vasarloi_adatok.csv");

        System.out.println("3. feladat:");
        long db = vasarlok.stream()
            .filter(v -> v.getNem().equals("N") && v.getVasarlasokSzama() >= 40)
            .count();
        System.out.println("Legalább 40-szer vásárló nők száma: " + db);

        System.out.println("4. feladat:");
        Optional<Vasarlo> wellUser = vasarlok.stream()
            .filter(v -> v.getFelhasznaloNev().contains("well"))
            .findFirst();
        if (wellUser.isPresent()) {
            Vasarlo v = wellUser.get();
            System.out.println("Talált felhasználó: " + v);
        } else {
            System.out.println("Nincs ilyen felhasználó.");
        }

        System.out.println("5. feladat:");
        Map<String, Long> stat = vasarlok.stream()
            .collect(Collectors.groupingBy(Vasarlo::getFizetesiMod, Collectors.counting()));
        stat.forEach((mod, count) -> System.out.println(mod + ": " + count + " fő"));
    }
}