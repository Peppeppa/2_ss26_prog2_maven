package de.thws.klausurvorbereitung.visitor5;

public interface DokumentElement {
    void accept(MarkdownVisitor visitor);
}