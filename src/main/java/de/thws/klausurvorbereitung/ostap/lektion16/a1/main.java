package de.thws.klausurvorbereitung.ostap.lektion16.a1;

public class main {
    public static void main(String[]args){
        Computer c = new Computer();
        Lampe l = new Lampe();
        c.einschalten();
        c.ausschalten();
        l.einschalten();
        l.ausschalten();
        System.out.println(c.an);
        System.out.println(c.aus);
    }
}
