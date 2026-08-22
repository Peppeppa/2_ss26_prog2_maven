package de.thws.klausurvorbereitung.altklausur.Aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe1<T> {


    public List<T> flatten(List<List<T>> list){
        List<T> result = new ArrayList<>();
        for(List<T> l1 : list){
            for(T s : l1){
                result.add(s);
            }
        }
        return result;
    }
}
