package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.List;

public class Motoroller extends Fahrzeug{

    double lateEntgeltProMin;

    public Motoroller(){
        super(0,0.15);

    }

    public List<Fahrt>getFahrtenbuch(){return this.fahrtenbuch;}
    public double berechneEntgelt(Fahrt fahrt){
       return 3.0+fahrt.km*this.entgeltProKM;
    }
    public void schreibeFahrt(Fahrt fahrt){
        fahrtenbuch.add(fahrt);
    }
}
