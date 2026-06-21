package de.thws.klausurvorbereitung.musikstuecksammlung;


import java.util.Comparator;

public class VergleicheMusikStueckLaenge implements Comparator<MusikStueck> {

    public int compare(MusikStueck m1, MusikStueck m2){
        return m1.laenge - m2.laenge;
    }
}
