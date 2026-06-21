package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.List;

public class Kleintransporter extends Fahrzeug{


    public Kleintransporter(){
        super(0.25,0.30);
    }

    public List<Fahrt> getFahrtenbuch(){return this.fahrtenbuch;}

    public double berechneEntgelt(Fahrt fahrt){
        if(fahrt.min>60){
            return(fahrt.km* entgeltProKM)+((fahrt.min-60)*entgeltProMIN);
        }else{
            return fahrt.km*entgeltProKM;
        }
    }


    public void schreibeFahrt(Fahrt fahrt){
        fahrtenbuch.add(fahrt);
    }
}
