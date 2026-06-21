package de.thws.klausurvorbereitung.visitor1;

public class CountVisitor implements ArtikelVisitor{
    int count = 0;

   public void visit(Artikel artikel){

       count++;

    }

    public int getCount(){
        return count;
    }

}
