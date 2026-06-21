package de.thws.klausurvorbereitung.musikstuecksammlung;


import java.util.*;

public class MusikStueckSammlung {

    Map<String, MusikStueck> sammlung = new HashMap<>();

   public void musikStueckEinfuegen(MusikStueck neu){
       sammlung.put(neu.titel, neu);
   }


    public List<MusikStueck> getAlleMusikStueckeNachTitel() {
        List<MusikStueck> result = new ArrayList<>(sammlung.values());

        result.sort(new VergleicheMusikStueckTitel());

        return result;
    }

    public List<MusikStueck> getAlleMusikStueckeNachLaenge() {
        List<MusikStueck> result = new ArrayList<>(sammlung.values());

        result.sort(new VergleicheMusikStueckLaenge());

        return result;
    }

}
