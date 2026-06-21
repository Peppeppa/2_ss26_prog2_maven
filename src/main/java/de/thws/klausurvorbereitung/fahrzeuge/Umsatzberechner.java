package de.thws.klausurvorbereitung.fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public class Umsatzberechner {

   List<Fahrt> alleFahrten;

   public Umsatzberechner(){
      List<Fahrt> alleFahrten = new ArrayList<>();

   }

   public double berechneUmsatz(List<Fahrzeug> fahrzeuge){

      double summe = 0;
      for (Fahrzeug f : fahrzeuge){
         for (Fahrt fahrten : f.getFahrtenbuch()){
            summe += f.berechneEntgelt(fahrten);
         }
      }
      return summe;

   }
}
