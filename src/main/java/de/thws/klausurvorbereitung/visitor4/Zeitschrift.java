package de.thws.klausurvorbereitung.visitor4;

public class Zeitschrift implements BibliothekElement {

    private String titel;
    private int seiten;

    public Zeitschrift(String titel, int seiten) {
        this.titel = titel;
        this.seiten = seiten;
    }

    public String getTitel() {
        return titel;
    }

    public int getSeiten() {
        return seiten;
    }

    @Override
    public void accept(BibliothekVisitor visitor) {
        // TODO
        visitor.visit(this);
    }
}