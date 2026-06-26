package de.thws.klausurvorbereitung.StreamingAPI.streams;

public class Artikel {

    private String name;
    private String kategorie;
    private double preis;

    public Artikel(String name, String kategorie, double preis) {
        this.name = name;
        this.kategorie = kategorie;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public String getKategorie() {
        return kategorie;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return name + " (" + kategorie + ", " + preis + ")";
    }
}