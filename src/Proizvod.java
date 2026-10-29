import java.util.Locale;

public class Proizvod {

    private static int brojac = 0;

    private final String sifra;
    private String naziv;
    private double cijena;
    private int kolicina;

    public Proizvod(String naziv, double cijena, int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Početna količina ne smije biti negativna: " + kolicina);
        }
        setNaziv(naziv);
        setCijena(cijena);
        this.kolicina = kolicina;
        brojac++;
        this.sifra = String.format("P%03d", brojac);
    }

    public Proizvod(String naziv, double cijena) {
        this(naziv, cijena, 0);
    }

    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setNaziv(String naziv) {
        if (naziv == null || naziv.trim().isEmpty()) {
            throw new IllegalArgumentException("Naziv ne smije biti prazan.");
        }
        this.naziv = naziv.trim();
    }

    public void setCijena(double cijena) {
        if (cijena < 0) {
            throw new IllegalArgumentException("Cijena ne smije biti negativna: " + cijena);
        }
        this.cijena = cijena;
    }

    public void dodaj(int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException("Količina za dodavanje mora biti pozitivna: " + kolicina);
        }
        this.kolicina += kolicina;
    }

    public void prodaj(int kolicina) {
        if (kolicina <= 0) {
            throw new IllegalArgumentException("Količina za prodaju mora biti pozitivna: " + kolicina);
        }
        if (kolicina > this.kolicina) {
            throw new IllegalArgumentException("Nema dovoljno na skladištu: traženo " + kolicina
                    + ", dostupno " + this.kolicina);
        }
        this.kolicina -= kolicina;
    }

    public double ukupnaVrijednost() {
        return cijena * kolicina;
    }

    public double ukupnaVrijednost(double popust) {
        if (popust < 0 || popust > 100) {
            throw new IllegalArgumentException("Popust mora biti između 0 i 100 %: " + popust);
        }
        return ukupnaVrijednost() * (1 - popust / 100);
    }

    public static int getBrojProizvoda() {
        return brojac;
    }

    public String opis() {
        return String.format(Locale.ROOT, "%s | %s | %.2f EUR | %d kom", sifra, naziv, cijena, kolicina);
    }
}
