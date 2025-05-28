package hu.katolikuskeri.szakmaivizsga2023.cli;

public class Vasarlo {
    private String felhasznaloNev;
    private String email;
    private int vasarlasokSzama;
    private String nem;
    private String fizetesiMod;

    public Vasarlo(String felhasznaloNev, String email, int vasarlasokSzama, String nem, String fizetesiMod) {
        this.felhasznaloNev = felhasznaloNev;
        this.email = email;
        this.vasarlasokSzama = vasarlasokSzama;
        this.nem = nem;
        this.fizetesiMod = fizetesiMod;
    }

    public String getFelhasznaloNev() { return felhasznaloNev; }
    public String getEmail() { return email; }
    public int getVasarlasokSzama() { return vasarlasokSzama; }
    public String getNem() { return nem; }
    public String getFizetesiMod() { return fizetesiMod; }

    @Override
    public String toString() {
        return email + " (" + felhasznaloNev + ")";
    }

    public static java.util.List<Vasarlo> beolvasas(String fajlnev) throws Exception {
        java.util.List<Vasarlo> lista = new java.util.ArrayList<>();
        java.nio.file.Files.lines(java.nio.file.Paths.get(fajlnev))
            .skip(1)
            .map(sor -> sor.split(";"))
            .forEach(adatok -> {
                lista.add(new Vasarlo(
                    adatok[0],
                    adatok[1],
                    Integer.parseInt(adatok[2]),
                    adatok[3],
                    adatok[4]
                ));
            });
        return lista;
    }
}