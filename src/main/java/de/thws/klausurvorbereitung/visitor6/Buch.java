package de.thws.klausurvorbereitung.visitor6;

public class Buch implements Produkt {

    private String titel;
    private double preis;

    public Buch(String titel, double preis) {
        this.titel = titel;
        this.preis = preis;
    }

    public String getTitel() {
        return titel;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public void accept(ProduktVisitor visitor) {
        // TODO

    }
}
