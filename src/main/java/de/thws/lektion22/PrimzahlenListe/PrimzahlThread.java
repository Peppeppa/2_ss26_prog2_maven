package de.thws.lektion22.PrimzahlenListe;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimzahlThread extends Thread{

    private ArrayList<Integer> zahlenListe;
    private Map<Integer, Boolean> ergebnis;

    public PrimzahlThread(ArrayList<Integer> zahlenListe) {
        this.zahlenListe = zahlenListe;
        this.ergebnis = new HashMap<>();
    }

    public Map<Integer, Boolean> getErgebnis() {
        return ergebnis;
    }

    private boolean testeObPrimzahl(int zahlZumTesten) {
        if (zahlZumTesten < 2) {
            return false;
        }

        for (int divisor = 2; divisor <= Math.sqrt(zahlZumTesten); divisor++) {
            if (zahlZumTesten % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {
        for (int zahl : zahlenListe) {
            boolean istPrimzahl = testeObPrimzahl(zahl);
            ergebnis.put(zahl, istPrimzahl);
        }
    }
}
