package de.thws.klausurvorbereitung.bibliothek;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Bibliothek {
    List<Buch> sammlung = new ArrayList<>();


    public void add(Buch buch){
        sammlung.add(buch);
    }

    public List<Buch> sortiere(){
        List<Buch> result = new ArrayList<>(sammlung);
        result.sort(Comparator.comparing(Buch::getAuthor)
                .thenComparing(Buch::getName));

        return result;
    }

    public List<Buch> sucheBuecherNachAuthor(String suchwort){

        List<Buch> result = new ArrayList<>(sammlung);
        return result.stream()
                .filter(buch -> buch.getAuthor().equals(suchwort))
                .toList();
    }


}
