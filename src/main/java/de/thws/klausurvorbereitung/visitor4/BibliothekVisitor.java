package de.thws.klausurvorbereitung.visitor4;

public interface BibliothekVisitor {

    void visit(Buch buch);
    void visit(Zeitschrift zeitschrift);
}
