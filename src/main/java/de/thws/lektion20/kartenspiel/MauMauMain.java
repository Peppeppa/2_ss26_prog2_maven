package de.thws.lektion20.kartenspiel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MauMauMain {

    public static void main(String[] args) {

        Kartendeck deck = new Kartendeck();
        deck.mischen();

        Spieler spieler = new Spieler("Stephen");

        int anzahlHandkarten = 5;

        for (int i = 0; i < anzahlHandkarten; i++) {
            Karte gezogeneKarte = deck.karteZiehen();
            spieler.karteAufnehmen(gezogeneKarte);
        }

        spieler.handAusgeben();

        Map<Farbe, Integer> farbenZaehler = new HashMap<>();

        Iterator<Karte> iterator = spieler.getHand().iterator();

        while (iterator.hasNext()) {
            Karte karte = iterator.next();
            Farbe farbe = karte.getFarbe();

            if (farbenZaehler.containsKey(farbe)) {
                int alterWert = farbenZaehler.get(farbe);
                farbenZaehler.put(farbe, alterWert + 1);
            } else {
                farbenZaehler.put(farbe, 1);
            }
        }

        System.out.println();
        System.out.println("Anzahl Karten pro Farbe:");

        for (Farbe farbe : farbenZaehler.keySet()) {
            System.out.println(farbe + ": " + farbenZaehler.get(farbe));
        }
    }
}
