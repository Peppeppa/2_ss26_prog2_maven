package de.thws.klausurvorbereitung.visitor2;

public class Rechteck implements Figur{
    private double breite;
    private double hoehe;

    public Rechteck(double breite, double hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    public double getBreite() {
        return breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    @Override
    public void accept(FigurVisitor visitor) {
        // TODO
        visitor.visit(this);
    }
}
