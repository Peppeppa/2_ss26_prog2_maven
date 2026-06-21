package de.thws.lektion15.getraenkevorraete;

public  class Getraenk {
   String herkunft;
   String sorte;
   double alkoholgehalt;
   String alkoholfrei;
   int flaschengroesse;
   int flaschenpfand;


    public Getraenk(String herkunft, String Sorte, double Alkoholgehalt, int flaschengroesse, int flaschenpfand) {
        this.herkunft = herkunft;
        this.sorte = Sorte;
        this.alkoholgehalt = Alkoholgehalt;
        if (Alkoholgehalt < 0.5) {
            this.alkoholfrei = "ja" ;
        } else {
            this.alkoholfrei = "nein";
        }
        this.flaschengroesse=flaschengroesse;
        this.flaschenpfand=flaschenpfand;
    }
}
