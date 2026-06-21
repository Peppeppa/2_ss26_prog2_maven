package de.thws.klausurvorbereitung.visitor3;

public class Datei implements DateisystemElement {

    private String name;
    private int groesse;

    public Datei(String name, int groesse) {
        this.name = name;
        this.groesse = groesse;
    }

    public String getName() {
        return name;
    }

    public int getGroesse() {
        return groesse;
    }

    @Override
    public void accept(DateisystemVisitor visitor) {
        visitor.visit(this);
    }
}