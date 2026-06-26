package de.thws.klausurvorbereitung.StreamingAPI.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Level5 {
    //Studenten nach Name in Map speichern
    public static Map<String, Student> mapStudentsByName(List<Student> students){
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Function.identity()
                ));
    }

    //Artikel nach Name in Map speichern
    public static Map<String, Artikel> mapArtikelByName(List<Artikel> artikel){
         return artikel.stream()
                 .collect(Collectors.toMap(
                         Artikel::getName,
                         Function.identity()
                 ));
    }

    //Anzahl Studenten pro Studiengang
    public static Map<String, Long> countStudentsByStudiengang(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getStudiengang,
                        Collectors.counting()
                ));
    }
    //Gruppiere Artikel nach Kategorie
    public static Map<String, List<Artikel>> groupArticlesByCategory(List<Artikel> artikel) {
        return artikel.stream()
                .collect(Collectors.groupingBy(
                        Artikel::getKategorie
                ));
    }
}
