package de.thws.klausurvorbereitung.bibliothek;

public class Hoerbuch extends Buch{

    int dauer;

    public Hoerbuch(String name, String autor, String verlag, int preisInCents, int dauer, String reihe){
        super(name, autor, verlag, preisInCents, reihe);
        this.dauer = dauer;
    }

}
