package de.thws.klausurvorbereitung.visitor4;

public class CountVisitor implements BibliothekVisitor{
    private int count;

    public void visit(Buch buch){

        count += buch.getSeiten();
    }
    public void visit(Zeitschrift zeitschrift){

    }
    public int getCount(){
        return count;
    }
}
