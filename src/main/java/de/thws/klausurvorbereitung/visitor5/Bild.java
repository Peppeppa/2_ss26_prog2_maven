package de.thws.klausurvorbereitung.visitor5;

public class Bild implements DokumentElement {

    private String dateiname;
    private String beschreibung;

    public Bild(String dateiname, String beschreibung) {
        this.dateiname = dateiname;
        this.beschreibung = beschreibung;
    }

    public String getDateiname() {
        return dateiname;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public void accept(MarkdownVisitor visitor) {
        // TODO
        visitor.visit(this);
    }
}