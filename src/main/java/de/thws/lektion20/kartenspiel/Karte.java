package de.thws.lektion20.kartenspiel;

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
    public int compareTo(Karte andereKarte){
        int compFarbe = this.farbe.compareTo(andereKarte.getFarbe());

        if (compFarbe != 0){
            return compFarbe;
        }

        return this.getWert().compareTo(andereKarte.getWert());
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

    @Override
    public int hashCode(){
        return Objects.hash(farbe, wert);
    }

}
