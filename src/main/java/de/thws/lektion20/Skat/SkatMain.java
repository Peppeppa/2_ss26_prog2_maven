package de.thws.lektion20.Skat;

public class SkatMain {

    public static void main(String[] args) {

        Kartendeck deck = new Kartendeck();
        deck.mischen();

        Spieler spieler = new Spieler("Stephen");

        int anzahlHandkarten = 10;

        for (int i = 0; i < anzahlHandkarten; i++) {
            Karte gezogeneKarte = deck.karteZiehen();
            spieler.karteAufnehmen(gezogeneKarte);
        }

        spieler.handAusgeben();
    }
}
