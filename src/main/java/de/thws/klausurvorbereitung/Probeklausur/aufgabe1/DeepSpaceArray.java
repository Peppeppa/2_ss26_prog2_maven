package de.thws.klausurvorbereitung.Probeklausur.aufgabe1;

public class DeepSpaceArray extends RadioTelescope implements SpecialCalibration{
    int linkedAntennas;

    public DeepSpaceArray(String name, int baujahr, double antenna, int linkedA){
        super(name, baujahr, antenna);
        this.linkedAntennas = linkedA;

    }
    public double observationPerformance(){
        return super.observationPerformance()+3*linkedAntennas;
    }
    public double calibrationValue(){

        return 2*linkedAntennas;
    }
}
