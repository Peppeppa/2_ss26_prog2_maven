package de.thws.klausurvorbereitung.ostap.lektion15.a2;

public class Auto extends Fahrzeug{

    public Auto(){
        this.tankstand = 60.0;
    }

    public void fahre(){
        System.out.println("Auto fährt");
        tankstand=-10;
    }


}
