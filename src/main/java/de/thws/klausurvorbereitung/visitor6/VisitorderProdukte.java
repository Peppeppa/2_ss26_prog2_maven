package de.thws.klausurvorbereitung.visitor6;

public interface VisitorderProdukte {
    void visit(Buch buch);
    void visit(Lebensmittel elektronik);
    void visit(Elektronik elektronik);
    void visit(ProduktSet set);
}
