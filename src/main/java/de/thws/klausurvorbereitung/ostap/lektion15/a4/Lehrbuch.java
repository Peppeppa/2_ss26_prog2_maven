package de.thws.klausurvorbereitung.ostap.lektion15.a4;

public class Lehrbuch extends Buch{
    String fachgebiet;

    public Lehrbuch(String tit, String aut, String fg){
        super(tit, aut);
        this.fachgebiet = fg;
    }

    public void zeigeInfo(){
        System.out.println(titel + author + fachgebiet);
    }
}
