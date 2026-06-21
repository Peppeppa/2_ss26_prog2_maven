package de.thws.klausurvorbereitung.visitor3;

public class GroessenVisitor implements DateisystemVisitor {

    private int gesamtGroesse = 0;

    public void visit(Datei datei){
        gesamtGroesse += datei.getGroesse();
    }
    // TODO

    public int getGesamtGroesse() {
        return gesamtGroesse;
    }
}