package de.thws.lektion22.multiThreadTCPServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimzahlenPruefer {

    private boolean testeObPrimzahl(int zahlZumTesten){
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

    public Map<Integer, Boolean> pruefeListe(ArrayList<Integer> zahlenliste){
        Map<Integer, Boolean> ergebnis = new HashMap<>();

        for (int zahl : zahlenliste) {
            boolean istPrimzahl = testeObPrimzahl(zahl);
            ergebnis.put(zahl, istPrimzahl);
        }
        return ergebnis;
    }

}
