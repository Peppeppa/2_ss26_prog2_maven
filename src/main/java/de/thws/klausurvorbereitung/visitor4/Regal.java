package de.thws.klausurvorbereitung.visitor4;

import de.thws.lektion15.ueb1.Ueb2Main;

import java.util.ArrayList;
import java.util.List;

public class Regal implements BibliothekElement {

    private String name;
    private List<BibliothekElement> elemente = new ArrayList<>();

    public Regal(String name) {
        this.name = name;
    }

    public void add(BibliothekElement element) {
        elemente.add(element);
    }

    public String getName() {
        return name;
    }

    public List<BibliothekElement> getElemente() {
        return elemente;
    }

    @Override
    public void accept(BibliothekVisitor visitor) {
        // TODO
        for (BibliothekElement element : elemente){
            element.accept(visitor);
        }
    }}
