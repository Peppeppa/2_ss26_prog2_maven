package de.thws.klausurvorbereitung.visitor6;

public interface Produkt {
    void accept(ProduktVisitor visitor);
}