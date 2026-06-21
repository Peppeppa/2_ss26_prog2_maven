package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.List;

public class Fahrrad extends Fahrzeug{


    public Fahrrad(){
        super(0.125,0);
    }

    public List<Fahrt> getFahrtenbuch(){return this.fahrtenbuch;}
    public double berechneEntgelt(Fahrt fahrt){
        return fahrt.min*this.entgeltProMIN;
    }
    public void schreibeFahrt(Fahrt fahrt){
        fahrtenbuch.add(fahrt);
    }
}
