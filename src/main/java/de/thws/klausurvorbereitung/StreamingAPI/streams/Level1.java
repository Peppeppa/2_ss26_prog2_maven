package de.thws.klausurvorbereitung.StreamingAPI.streams;

import java.util.List;

public class Level1 {

    public static void printAll(List<String> names){
        //Alle Namen ausgeben
       names.stream()
               .forEach(System.out::println);
       //schneller:
//        names.forEach(System.out::println);
    }

    // Namen filtern
    public static List<String> namesStartingWith(List<String> names, String prefix) {
        return names.stream()
                .filter(s -> s.startsWith(prefix))
                .toList();
    }


    //Name in Grossbuchstaben
    public static List<String> toUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .toList();
    }
    //Namen sortiert alphabetisch
    public static List<String> sortNames(List<String> names) {
        List<String> result = names.stream()
                .sorted()
                .toList();
        return result;
    }

    //Anzahl langer Namen
    public static long countLongNames(List<String> names, int minLength) {
        return names.stream()
                .filter(s -> s.length() >= minLength)
                .count();
    }



}
