package de.thws.lektion15.ueb1;

public class Angestellter {
    String nachname;
    String vorname;
    String identifikator;
    double grundgehalt;
    double gehaltsfaktor;
    String geburtsdatum;
    double gehalt;

    public Angestellter(String nachname, String vorname, String identifikator, double grundgehalt, String geburtsdatum){
        this.nachname=nachname;
        this.vorname=vorname;
        this.identifikator=identifikator;
        this.grundgehalt=grundgehalt;
        gehaltsfaktor=1.0;
        this.geburtsdatum=geburtsdatum;
        this.gehalt = grundgehalt;
    }

    public void berechneGehalt(){
        gehalt = grundgehalt*gehaltsfaktor;
    }


}
