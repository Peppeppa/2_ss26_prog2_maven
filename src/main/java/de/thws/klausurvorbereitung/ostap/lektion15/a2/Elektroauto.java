package de.thws.klausurvorbereitung.ostap.lektion15.a2;

public class Elektroauto extends Fahrzeug{
    public Elektroauto(){
        this.tankstand = 80.0;
    }
    public void fahre(){
        System.out.println("Auto fährt");
        tankstand=-10;
    }
}
