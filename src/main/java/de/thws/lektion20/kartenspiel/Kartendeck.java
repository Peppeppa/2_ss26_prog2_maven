package de.thws.lektion20.kartenspiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartendeck {
    private List<Karte> karten;

    public Kartendeck(){
        karten = new ArrayList<>();
        erstelleMauMauDeck();
    }

    private void erstelleMauMauDeck() {
        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()) {
                karten.add(new Karte(farbe, wert));
            }
        }
    }

    public void mischen() {
        Collections.shuffle(karten);
    }

    public Karte karteZiehen() {
        if (karten.isEmpty()) {
            return null;
        }

        return karten.remove(0);
    }


}
