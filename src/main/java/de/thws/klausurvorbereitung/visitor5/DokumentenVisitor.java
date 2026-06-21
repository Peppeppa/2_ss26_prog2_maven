package de.thws.klausurvorbereitung.visitor5;

public interface DokumentenVisitor {
    void visit(Bild bild);
    void visit(TextAbschnitt textAbschnitt);
    void visit(Kapitel kapitel);

}
