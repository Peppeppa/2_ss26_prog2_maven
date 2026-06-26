package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

public class AdaptiveOpticsTelescope extends OpticalTelescope implements SpecialCalibration{

    int adaptiveMirrors;

    public AdaptiveOpticsTelescope(String name, int jahr, double aperture, int mirrors){
        super(name, jahr, aperture);
        this.adaptiveMirrors = mirrors;
    }
    public double observationPerformance(){
        return super()+2*adaptiveMirrors;
    }
    public double calibrationValue(){

        return 1.5*adaptiveMirrors;
    }
}
