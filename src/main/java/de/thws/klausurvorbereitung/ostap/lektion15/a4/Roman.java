package de.thws.klausurvorbereitung.ostap.lektion15.a4;

public class Roman extends Buch{
    String genre;

    public Roman (String tit, String aut, String genre){
        super(tit, aut);
        this.genre = genre;
    }

    public void zeigeInfo(){

        System.out.println(titel + author + genre);
    }
}
