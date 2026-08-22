package de.thws.klausurvorbereitung.altklausur.Aufgabe2;

public class Raetselspiel extends Artikel implements EinmalVerwendbar{
    private boolean einmalVerwendbar;


    public Raetselspiel(String name){
        super(name);
        this.einmalVerwendbar = false;
    }

    @Override
    public boolean istEinmalVerwendbar() {
        return einmalVerwendbar;
    }
}
