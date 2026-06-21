package de.thws.lektion15.getraenkevorraete;

public class Bier extends Getraenk{


    public Bier(String sorte, String herkunft, double alkoholgehalt, int flaschengroesse, int flaschenpfand){
        super(herkunft, sorte, alkoholgehalt, flaschengroesse, flaschenpfand);
    }

    @Override
    public String toString(){
        return "Herkunft: " + this.herkunft +
                "\nSorte: " + this.sorte +
                "\n Alkoholgehalt: " + this.alkoholgehalt +
                "\n alkoholfrei: " + alkoholfrei;
    }
}
