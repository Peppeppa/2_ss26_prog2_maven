package de.thws.klausurvorbereitung.visitor6;

public class Lebensmittel implements Produkt {

    private String name;
    private double preis;
    private boolean gekuehlt;

    public Lebensmittel(String name, double preis, boolean gekuehlt) {
        this.name = name;
        this.preis = preis;
        this.gekuehlt = gekuehlt;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public boolean isGekuehlt() {
        return gekuehlt;
    }

    @Override
    public void accept(ProduktVisitor visitor) {
        // TODO
    }
}