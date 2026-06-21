package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public class Fuhrpark {
    private List<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void addFahrzeug(Fahrzeug f){
        fahrzeuge.add(f);
    }

    public List<Fahrzeug> getFahrzeuge(){
        return fahrzeuge;
    }
}
