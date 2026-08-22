package de.thws.klausurvorbereitung.ostap.lektion15.a2;

public abstract class Fahrzeug {
    double tankstand;

    abstract void fahre();
    public double tankstand(){
        return tankstand;
    }

    public static void fahrzeugeTesten(Fahrzeug[] fahrzeuge){
        for(Fahrzeug fz:fahrzeuge){
            fz.tankstand();
            fz.fahre();
            fz.tankstand();
        }
    }

    public static void main(String[]args){
        Fahrzeug a = new Auto();
        Fahrzeug b = new Fahrrad();
        Fahrzeug c = new Elektroauto();

        Fahrzeug[] f = {a , b , c};

        fahrzeugeTesten(f);
    }
}
