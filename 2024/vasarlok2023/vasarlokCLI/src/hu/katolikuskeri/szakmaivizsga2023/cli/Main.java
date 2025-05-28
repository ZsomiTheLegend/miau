package hu.katolikuskeri.szakmaivizsga2023.cli;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. feladat:");

        List<Vasarlo> vasarlok = Vasarlo.beolvasas("vasarloi_adatok.csv");

        // 6. feladat: hány női vásárló van, aki legalább 40 vásárláson túl van
        long noiVasarlokSzama = vasarlok.stream()
                .filter(v -> v.getNem() == 'N' && v.getVasarlasokSzama() > 40)
                .count();
        System.out.println("6. feladat:");
        System.out.println("40-nél több vásárlással rendelkező női vásárlók száma: " + noiVasarlokSzama);

        // 7. feladat: van-e olyan felhasználó, akinek a felhasználónevében "well" szerepel
        List<Vasarlo> wellVasarlok = vasarlok.stream()
                .filter(v -> v.getFelhasznaloNev().toLowerCase().contains("well"))
                .collect(Collectors.toList());
        System.out.println("7. feladat:");
        if (wellVasarlok.isEmpty()) {
            System.out.println("Nincs olyan felhasználó, akinek a felhasználónevében szerepel a \"well\".");
        } else {
            System.out.println("Van olyan felhasználó, akinek a felhasználónevében szerepel a \"well\":");
            for (Vasarlo v : wellVasarlok) {
                System.out.println(v.getFelhasznaloNev() + "; " + v.getEmail() + "; " + v.getVasarlasokSzama() + "; " + v.getNem() + "; " + v.getFizetesiMod());
            }
        }

        // 8. feladat: statisztika a fizetési módokról
        System.out.println("8. feladat:");
        Map<String, Long> fizetesiModStat = vasarlok.stream()
                .collect(Collectors.groupingBy(Vasarlo::getFizetesiMod, Collectors.counting()));
        for (Map.Entry<String, Long> entry : fizetesiModStat.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " felhasználó");
        }
    }
}
