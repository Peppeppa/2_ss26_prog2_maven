package de.thws.klausurvorbereitung.altklausur.Aufgabe2;

public class Buch extends Artikel{
    int Seitenzahl;

    public Buch(String name, int seitenzahl){
        super(name);
        this.Seitenzahl = seitenzahl;
    }
}
