package de.thws.lektion14;

public class Person {
    String vorname;
    String nachname;
    Adresse adresse;

    public Person(String vorname, String nachname, String strasse, String hausnummer, int plz, String ort){
        if(!Character.isUpperCase(vorname.charAt(0))){
            throw new IllegalArgumentException("Vorname muss großgeschrieben sein");
        }
        this.vorname = vorname;
        this.nachname = nachname;
        adresse = new Adresse(strasse, hausnummer, plz, ort);
    }

}
