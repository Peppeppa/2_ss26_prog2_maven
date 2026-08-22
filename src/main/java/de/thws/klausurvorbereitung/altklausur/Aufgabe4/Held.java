package de.thws.klausurvorbereitung.altklausur.Aufgabe4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Held {
    String name;
    Rasse rasse;

    public Held(String name, Rasse rasse){
        this.name = name;
        this.rasse= rasse;
    }

    public List<Held> sortRasse(List<Held> alt, String rasse){
        List<Held> result = new ArrayList<>(alt).stream()
                .filter(held -> held.rasse.equals(rasse))
                .toList();
        return result;
    }

    public Map<Rasse, Held> mapper(List<Held> held){
        return held.stream()
                .collect(Collectors.groupingBy(held ->held.rasse));
    }

}
