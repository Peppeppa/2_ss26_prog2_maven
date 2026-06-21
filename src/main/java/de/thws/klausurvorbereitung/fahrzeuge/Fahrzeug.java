package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug {
    double entgeltProMIN; //cent
    double entgeltProKM;
    List<Fahrt> fahrtenbuch;

    public Fahrzeug(double entgeltProMIN, double entgeltProKM){
        this.entgeltProMIN = entgeltProMIN;
        this.entgeltProKM = entgeltProKM;
        this.fahrtenbuch = new ArrayList<>();
    }

    public abstract List<Fahrt> getFahrtenbuch();
    public abstract double berechneEntgelt(Fahrt fahrt);
    public abstract void schreibeFahrt(Fahrt fahrt);

}
