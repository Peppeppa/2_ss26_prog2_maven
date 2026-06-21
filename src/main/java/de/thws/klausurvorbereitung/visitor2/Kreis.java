package de.thws.klausurvorbereitung.visitor2;

public class Kreis implements Figur{
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(FigurVisitor visitor) {
        // TODO
        visitor.visit(this);
    }
}
