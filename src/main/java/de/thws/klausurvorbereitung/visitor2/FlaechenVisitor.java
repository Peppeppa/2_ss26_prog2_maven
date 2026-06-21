package de.thws.klausurvorbereitung.visitor2;

public class FlaechenVisitor implements FigurVisitor{
    double gesamtFlaeche;
    final double PI = Math.PI;

    public void visit(Kreis kreis){
       gesamtFlaeche += PI*Math.pow(kreis.getRadius(), 2);
    }
    public void visit(Rechteck rechteck){
       gesamtFlaeche += rechteck.getHoehe()*rechteck.getBreite();
    }
    public double getGesamtFlaeche(){
        return gesamtFlaeche;
    }
}
