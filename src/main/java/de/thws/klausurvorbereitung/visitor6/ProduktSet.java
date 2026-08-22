package de.thws.klausurvorbereitung.visitor6;

import java.util.ArrayList;
import java.util.List;

public class ProduktSet implements Produkt {

    private String name;
    private List<Produkt> produkte = new ArrayList<>();

    public ProduktSet(String name) {
        this.name = name;
    }

    public void add(Produkt produkt) {
        produkte.add(produkt);
    }

    public String getName() {
        return name;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    @Override
    public void accept(ProduktVisitor visitor) {
        // TODO

        for(Produkt prod : produkte){
            prod.accept(visitor);
        }
    }
}
