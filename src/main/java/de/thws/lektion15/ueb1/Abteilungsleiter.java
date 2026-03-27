package de.thws.lektion15.ueb1;

public class Abteilungsleiter extends Angestellter{


    public Abteilungsleiter(String nachname, String vorname, String identifikator, double grundgehalt, String geburtsdatum) {
        super(nachname, vorname, identifikator, grundgehalt, geburtsdatum);
        gehaltsfaktor = 2.0;
        berechneGehalt();

    }

    public void befoerdern(Angestellter a){
        a.gehaltsfaktor *= 1.1;
        a.berechneGehalt();
    }

}
