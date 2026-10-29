public class Main {

    public static void main(String[] args) {
        Proizvod mlijeko = new Proizvod("Mlijeko 1 L", 1.29, 40);
        Proizvod caj = new Proizvod("  Čaj od kamilice  ", 3.50);  
        Proizvod kruh = new Proizvod("Kruh", 2.10, 15);

        System.out.println("--- Početno stanje ---");
        System.out.println(mlijeko.opis());
        System.out.println(caj.opis());
        System.out.println(kruh.opis());
        System.out.println("Stvoreno proizvoda: " + Proizvod.getBrojProizvoda());

        System.out.println();
        System.out.println("--- Promjene stanja ---");
        caj.dodaj(12);
        mlijeko.prodaj(5);
        kruh.setCijena(2.30);
        kruh.setNaziv("Kruh polubijeli");
        System.out.println(mlijeko.opis());
        System.out.println(caj.opis());
        System.out.println(kruh.opis());

        System.out.println();
        System.out.println("--- Ukupna vrijednost ---");
        System.out.printf("%s: %.2f EUR%n", mlijeko.getNaziv(), mlijeko.ukupnaVrijednost());
        System.out.printf("%s uz 10 %% popusta: %.2f EUR%n", mlijeko.getNaziv(), mlijeko.ukupnaVrijednost(10));
        System.out.printf("%s: %.2f EUR%n", caj.getNaziv(), caj.ukupnaVrijednost());
        System.out.printf("%s uz 25 %% popusta: %.2f EUR%n", caj.getNaziv(), caj.ukupnaVrijednost(25));

        System.out.println();
        System.out.println("--- Pokušaji neispravnih vrijednosti ---");
        try {
            mlijeko.prodaj(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            kruh.setCijena(-1.5);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            caj.setNaziv("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            new Proizvod(null, 1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }
        try {
            new Proizvod("Sok", 1.99, -3);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Stanje nakon odbijenih pokušaja (nepromijenjeno) ---");
        System.out.println(mlijeko.opis());
        System.out.println(caj.opis());
        System.out.println(kruh.opis());
        System.out.println("Stvoreno proizvoda: " + Proizvod.getBrojProizvoda());
    }
}
