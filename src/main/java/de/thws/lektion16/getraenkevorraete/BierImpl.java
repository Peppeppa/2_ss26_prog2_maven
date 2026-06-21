package de.thws.lektion16.getraenkevorraete;

public class BierImpl extends GetraenkImpl {


    public BierImpl(String sorte, String herkunft, double alkoholgehalt){
        super(herkunft, sorte, alkoholgehalt);
    }

    @Override
    public String toString(){
        return "Herkunft: " + this.herkunft +
                "\nSorte: " + this.Sorte +
                "\n Alkoholgehalt: " + this.Alkoholgehalt +
                "\n alkoholfrei: " + Alkoholfrei;
    }
}
