package de.thws.klausurvorbereitung.StreamingAPI.streams;
import java.util.*;

public class Level8 {
    //Listen zusammenführen
    public static List<String>flatten(List<List<String>> lists){
        return lists.stream()
                .flatMap(list -> list.stream())
                .toList();
    }

    //Alle Wörter aus Sätzen extrahieren
    public static List<String> getWords(List<String> sentences){
        return sentences.stream()
                .map(sentence -> sentence.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .toList();
    }


}
