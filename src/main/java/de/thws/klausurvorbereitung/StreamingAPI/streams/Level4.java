package de.thws.klausurvorbereitung.StreamingAPI.streams;
import java.util.*;
import java.util.stream.Collectors;

public class Level4 {
    //Doppelte Namen entfernen
    public static List<String> removeDuplicates(List<String> names){
        return names.stream()
                .distinct()
                .toList();
    }

    //Studiengänge als Set zurückgeben
    public static Set<String> getStudiengaenge(List<Student> students){
        return students.stream()
                .map(Student::getStudiengang)
                .collect(Collectors.toSet());
    }

    //Kategorien aller Artikel
    public static Set<String> getKategorien(List<Artikel> artikel){
        return artikel.stream()
                .map(Artikel::getKategorie)
                .collect(Collectors.toSet());
    }

}
