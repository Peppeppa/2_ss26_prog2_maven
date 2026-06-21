package de.thws.klausurvorbereitung.musikstuecksammlung;


import java.util.Comparator;

public class VergleicheMusikStueckTitel implements Comparator<MusikStueck> {

    public int compare(MusikStueck m1, MusikStueck m2){

        return m1.titel.compareTo(m2.titel);

    }
}
