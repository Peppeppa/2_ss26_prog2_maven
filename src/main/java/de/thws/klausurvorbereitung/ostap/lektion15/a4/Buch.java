package de.thws.klausurvorbereitung.ostap.lektion15.a4;

public abstract class Buch {
    String titel;
    String author;

    public Buch(String tit, String author){
        this.titel = tit;
        this.author = author;

    }

    abstract public void zeigeInfo();

    static void main() {
        Buch a = new Lehrbuch("1", "a", "999");
        Buch b = new Roman("roman", "ich", "top");
        Buch[] bl   = {a,b};
        for(Buch x:bl){
            x.zeigeInfo();
        }
    }
}
