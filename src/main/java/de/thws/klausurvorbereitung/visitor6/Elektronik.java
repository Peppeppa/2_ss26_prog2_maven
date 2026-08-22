package de.thws.klausurvorbereitung.visitor6;

public class Elektronik implements Produkt {

    private String name;
    private double preis;
    private int garantieMonate;

    public Elektronik(String name, double preis, int garantieMonate) {
        this.name = name;
        this.preis = preis;
        this.garantieMonate = garantieMonate;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public int getGarantieMonate() {
        return garantieMonate;
    }

    @Override
    public void accept(ProduktVisitor visitor) {
        // TODO
    }
}
