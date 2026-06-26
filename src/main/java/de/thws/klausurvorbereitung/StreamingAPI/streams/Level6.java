package de.thws.klausurvorbereitung.StreamingAPI.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Level6 {
    //Generische Filter-Methode
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate){

        return list.stream()
                .filter(predicate)
                .toList();
    }


    //Generische Map-Methode
    public static <T, R> List<R> mapList(List<T> list, Function<T, R> function){
        return list.stream()
                .map(function)
                .toList();
    }
    // Generische Sortier-Methode
    public static <T> List<T> sortList(List<T> list, Comparator<T> comparator) {
        return list.stream()
                .sorted(comparator)
                .toList();
    }

    // Erstes passendes Element finden
    public static <T> Optional<T> findFirstMatching(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst();
    }

    // Prüfen, ob irgendein Element passt
    public static <T> boolean anyMatches(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .anyMatch(predicate);
    }

    // Prüfen, ob alle Elemente passen
    public static <T> boolean allMatch(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .allMatch(predicate);
    }
}
