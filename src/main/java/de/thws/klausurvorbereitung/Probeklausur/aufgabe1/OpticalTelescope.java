package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

public class OpticalTelescope extends ObservationInstrument{
   double aperture;

    public OpticalTelescope(String name, int baujahr, double aperture){
        super(name, baujahr);
        this.aperture = aperture;
    }

    public double observationPerformance(){
       return 10*aperture;
    }
}
