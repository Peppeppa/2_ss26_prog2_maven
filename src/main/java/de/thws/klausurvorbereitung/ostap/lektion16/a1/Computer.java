package de.thws.klausurvorbereitung.ostap.lektion16.a1;

public class Computer implements Bedienbar{
    int an = 0;
    int aus = 0;

    public void einschalten(){
        System.out.println("Computer an");
        an++;
    }
    public void ausschalten(){
        System.out.println("Computer aus");
        aus++;
    }
}
