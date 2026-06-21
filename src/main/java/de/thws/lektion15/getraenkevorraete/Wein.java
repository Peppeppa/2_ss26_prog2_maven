package de.thws.lektion15.getraenkevorraete;

public class Wein extends Getraenk{
    int jahrgang;

    public Wein(String herkunft, String Sorte, double Alkoholgehalt, int Jahrgang, int flaschengroesse, int flaschenpfand){
        super(herkunft, Sorte, Alkoholgehalt, flaschengroesse, flaschenpfand);
        this.jahrgang=Jahrgang;
    }

    public String toString() {
        return "Herkunft: " + this.herkunft +
                "\nSorte: " + this.sorte +
                "\n Alkoholgehalt: " + this.alkoholgehalt +
                "\n Jahrgang: " + this.jahrgang +
                "\n alkoholfrei: " + alkoholfrei;
    }
}
