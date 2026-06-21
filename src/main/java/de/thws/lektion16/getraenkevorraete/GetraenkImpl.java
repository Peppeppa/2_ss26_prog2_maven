package de.thws.lektion16.getraenkevorraete;

public  class GetraenkImpl {
   String herkunft;
   String Sorte;
   double Alkoholgehalt;
   String Alkoholfrei;


    public GetraenkImpl(String herkunft, String Sorte, double Alkoholgehalt) {
        this.herkunft = herkunft;
        this.Sorte = Sorte;
        this.Alkoholgehalt = Alkoholgehalt;
        if (Alkoholgehalt < 0.5) {
            this.Alkoholfrei = "ja" ;
        } else {
            this.Alkoholfrei = "nein";
        }
    }
}
