package de.thws.klausurvorbereitung.visitor5;

import java.util.ArrayList;
import java.util.List;

public class Kapitel implements DokumentElement {

    private String titel;
    private List<DokumentElement> elemente = new ArrayList<>();

    public Kapitel(String titel) {
        this.titel = titel;
    }

    public void add(DokumentElement element) {
        elemente.add(element);
    }

    public String getTitel() {
        return titel;
    }

    public List<DokumentElement> getElemente() {
        return elemente;
    }

    @Override
    public void accept(MarkdownVisitor visitor) {
        // TODO
        visitor.visit(this);
        for (DokumentElement de:elemente){
            de.accept(visitor);
        }
    }
}