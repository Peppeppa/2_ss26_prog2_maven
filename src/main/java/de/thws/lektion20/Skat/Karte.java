package de.thws.lektion20.Skat;

import java.util.Objects;

public class Karte implements Spielkarte, Comparable<Karte>{

    private Farbe farbe;
    private Wert wert;

    public Karte(Farbe farbe, Wert wert){
        this.farbe = farbe;
        this.wert = wert;
    }

    @Override
    public Farbe getFarbe(){
        return farbe;
    }
    @Override
    public Wert getWert(){
        return wert;
    }
    @Override
    public String toString(){
        return farbe + " " + wert;
    }

    @Override
    public int compareTo (Karte andereKarte){

        int vergleichGruppe = Integer.compare(
                this.getSortierGruppe(),
                andereKarte.getSortierGruppe()
        );

        if (vergleichGruppe != 0) {
            return vergleichGruppe;
        }

        int vergleichFarbe = Integer.compare(
                this.getFarbRang(),
                andereKarte.getFarbRang()
        );

        if (vergleichFarbe != 0) {
            return vergleichFarbe;
        }

        return Integer.compare(
                this.getWertRang(),
                andereKarte.getWertRang()
        );
    }

    private int getSortierGruppe() {
        if (this.wert == Wert.BUBE) {
            return 0; // Buben kommen zuerst
        }

        return 1; // alle anderen Karten danach
    }

    private int getFarbRang() {
        switch (this.farbe) {
            case KREUZ:
                return 0;
            case PIK:
                return 1;
            case HERZ:
                return 2;
            case KARO:
                return 3;
            default:
                return 4;
        }
    }

    private int getWertRang() {
        if (this.wert == Wert.BUBE) {
            return 0;
        }

        switch (this.wert) {
            case ASS:
                return 0;
            case ZEHN:
                return 1;
            case KOENIG:
                return 2;
            case DAME:
                return 3;
            case NEUN:
                return 4;
            case ACHT:
                return 5;
            case SIEBEN:
                return 6;
            default:
                return 7;
        }
    }



    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Karte)){
            return false;
        }
        Karte andereKArte = (Karte) obj;
        return this.getFarbe().equals(andereKArte.getFarbe()) && this.getWert().equals(andereKArte.getWert());
    }
}