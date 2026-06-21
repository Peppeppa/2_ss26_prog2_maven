package de.thws.klausurvorbereitung.visitor4;

public interface BibliothekElement {
    void accept(BibliothekVisitor visitor);
}