package de.thws.lektion14;

public class Adresse {
    String strasse;
    String hausnummer;
    int postleitzahl;
    String ort;

    public Adresse(String strasse, String hausnummer, int postleitzahl, String ort){
        if(!Character.isUpperCase(strasse.charAt(0))){
            throw new IllegalArgumentException("Strasse muss mit Großbuchstaben beginnen");
        }
        if(!Character.isUpperCase(ort.charAt(0))){
            throw new IllegalArgumentException("Ort muss mit Großbuchstaben beginnen");
        }
        if(!Character.isDigit (hausnummer.charAt(0))){
            throw new IllegalArgumentException("Hausnummer muss mit einer Ziffer beginnen");
        }
        this.strasse = strasse;
        this.hausnummer= hausnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }
}
