package de.thws.klausurvorbereitung.visitor1;

import java.util.ArrayList;
import java.util.List;

public class Einkaufswagen {
    private List<Artikel> artikelListe = new ArrayList<>();

    public void addArtikel(Artikel artikel) {
        artikelListe.add(artikel);
    }

    public void traversiere(ArtikelVisitor visitor) {
        // TODO:
        // Laufe über alle Artikel in artikelListe
        // und rufe für jeden Artikel visitor.visit(...) auf
        for(Artikel a : artikelListe){
            visitor.visit(a);
        }
    }
}
