package de.thws.klausurvorbereitung.visitor3;

import java.util.ArrayList;
import java.util.List;

public class Ordner implements DateisystemElement {

    private String name;
    private List<DateisystemElement> elemente = new ArrayList<>();

    public Ordner(String name) {
        this.name = name;
    }

    public void add(DateisystemElement element) {
        elemente.add(element);
    }

    public String getName() {
        return name;
    }

    public List<DateisystemElement> getElemente() {
        return elemente;
    }

    @Override
    public void accept(DateisystemVisitor visitor) {
        // TODO
        for (DateisystemElement element : elemente){
            element.accept(visitor);
        }

    }
}