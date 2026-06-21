package de.thws.klausurvorbereitung.visitor2;

public interface FigurVisitor {
    void visit(Kreis kreis);
    void visit(Rechteck rechteck);
}
