package de.thws.klausurvorbereitung.baumvisitor;

public class Baum<E extends Comparable<E>>
{
    public static class Knoten<E>
    {
        Knoten<E> left;
        Knoten<E> right;
        E content;
    }

    Knoten<E> root;

    public void einfuegen(E content) {
        // einfügen
    }

    public int size(){
        CountVisitor<E> visitor = new CountVisitor<>();
        this.traversiere(visitor);
        return visitor.getCount();
    }


    public void traversiere(Visitor<E> visitor)
    {
        if (root == null) return;
        else traversiere(root, visitor);
    }
    protected void traversiere(Knoten<E> current, Visitor<E> visitor)
    {
        if (current.left != null) traversiere(current.left, visitor);
        visitor.visit(current);
        if (current.right != null) traversiere(current.right, visitor);
    }
}
