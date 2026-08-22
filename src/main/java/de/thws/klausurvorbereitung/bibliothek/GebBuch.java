package de.thws.klausurvorbereitung.bibliothek;

public class GebBuch extends Buch{
    int seitenanzahl;


    public GebBuch(String name, String autor, String verlag, int preisInCents, int seitenanzahl, String reihe){
        super(name, autor, verlag, preisInCents, reihe);
        this.seitenanzahl  = seitenanzahl;

    }

    }
