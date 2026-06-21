package de.thws.klausurvorbereitung.baumvisitor;

public interface Visitor<T> {
    public void visit(Baum.Knoten<T> current);
}
