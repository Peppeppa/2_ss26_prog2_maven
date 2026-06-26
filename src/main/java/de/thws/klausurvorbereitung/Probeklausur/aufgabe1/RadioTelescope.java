package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

public class RadioTelescope extends ObservationInstrument {
    double antennaDiameter;

    public RadioTelescope(String name, int jahr, double antennaDiameter){
        super(name, jahr);
        this.antennaDiameter = antennaDiameter;

    }
    public double observationPerformance(){
        return 5*antennaDiameter;
    }
}
