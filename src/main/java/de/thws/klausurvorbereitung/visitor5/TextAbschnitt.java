package de.thws.klausurvorbereitung.visitor5;

public class TextAbschnitt implements DokumentElement {

    private String text;

    public TextAbschnitt(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(MarkdownVisitor visitor) {
        // TODO
        visitor.visit(this);
    }
}