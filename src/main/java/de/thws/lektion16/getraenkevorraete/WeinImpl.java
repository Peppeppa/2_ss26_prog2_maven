package de.thws.lektion16.getraenkevorraete;

public class WeinImpl extends GetraenkImpl {
    int jahrgang;

    public WeinImpl(String herkunft, String Sorte, double Alkoholgehalt, int Jahrgang){
        super(herkunft, Sorte, Alkoholgehalt);
        this.jahrgang=Jahrgang;
    }

    public String toString() {
        return "Herkunft: " + this.herkunft +
                "\nSorte: " + this.Sorte +
                "\n Alkoholgehalt: " + this.Alkoholgehalt +
                "\n Jahrgang: " + this.jahrgang +
                "\n alkoholfrei: " + Alkoholfrei;
    }
}
