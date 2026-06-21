package de.thws.klausurvorbereitung.visitor1;

public class main {
    static void main() {
        Einkaufswagen wagen = new Einkaufswagen();

        wagen.addArtikel(new Artikel("Brot", 2.49));
        wagen.addArtikel(new Artikel("Milch", 1.29));
        wagen.addArtikel(new Artikel("Käse", 3.99));

        CountVisitor visitor = new CountVisitor();

        wagen.traversiere(visitor);

        System.out.println("Anzahl Artikel: " + visitor.getCount());
    }

}
