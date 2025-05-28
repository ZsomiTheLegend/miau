package hu.katolikuskeri.szakmaivizsga2023.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vasarlo {
    private String felhasznaloNev;
    private String email;
    private int vasarlasokSzama;
    private char nem; // 'N' - nő, 'F' - férfi
    private String fizetesiMod;

    public Vasarlo(String felhasznaloNev, String email, int vasarlasokSzama, char nem, String fizetesiMod) {
        this.felhasznaloNev = felhasznaloNev;
        this.email = email;
        this.vasarlasokSzama = vasarlasokSzama;
        this.nem = nem;
        this.fizetesiMod = fizetesiMod;
    }

    // Getters and setters
    public String getFelhasznaloNev() {
        return felhasznaloNev;
    }

    public void setFelhasznaloNev(String felhasznaloNev) {
        this.felhasznaloNev = felhasznaloNev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVasarlasokSzama() {
        return vasarlasokSzama;
    }

    public void setVasarlasokSzama(int vasarlasokSzama) {
        this.vasarlasokSzama = vasarlasokSzama;
    }

    public char getNem() {
        return nem;
    }

    public void setNem(char nem) {
        this.nem = nem;
    }

    public String getFizetesiMod() {
        return fizetesiMod;
    }

    public void setFizetesiMod(String fizetesiMod) {
        this.fizetesiMod = fizetesiMod;
    }

    @Override
    public String toString() {
        return email + " (" + felhasznaloNev + ")";
    }

    public static List<Vasarlo> beolvasas(String fajlNev) {
        List<Vasarlo> vasarlok = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fajlNev))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String felhasznaloNev = parts[0];
                    String email = parts[1];
                    int vasarlasokSzama = Integer.parseInt(parts[2]);
                    char nem = parts[3].charAt(0);
                    String fizetesiMod = parts[4];
                    Vasarlo v = new Vasarlo(felhasznaloNev, email, vasarlasokSzama, nem, fizetesiMod);
                    vasarlok.add(v);
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba a fájl beolvasásakor: " + e.getMessage());
        }
        return vasarlok;
    }
}
