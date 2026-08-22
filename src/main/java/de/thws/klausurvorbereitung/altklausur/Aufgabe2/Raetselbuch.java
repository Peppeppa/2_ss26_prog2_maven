package de.thws.klausurvorbereitung.altklausur.Aufgabe2;

public class Raetselbuch extends Buch implements EinmalVerwendbar{

    private boolean einmalVerwendbar;

    public Raetselbuch(String name, int seiten){
        super(name, seiten);
        this.einmalVerwendbar = false;
    }

    @Override
    public boolean istEinmalVerwendbar() {
        return einmalVerwendbar;
    }
}
