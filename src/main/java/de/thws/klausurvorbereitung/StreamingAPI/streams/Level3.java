package de.thws.klausurvorbereitung.StreamingAPI.streams;

import java.util.*;


public class Level3 {

    //durchschnittsnoten berechnen
    public static double getAverageGrade(List<Student> students) {
        return students.stream()
                .mapToDouble(s -> s.getNote())
                .average()
                .orElse(0.0);
    }

    //Durchschnittsalter berechnen
   public static double getAverageAge(List<Student> students){
        return students.stream()
                //.mapToInt(s -> s.getAlter())
                .mapToInt(Student::getAlter)
                .average()
                .orElse(0);
   }

   //Summe aller Artikelpreise
    public static double sumPrices(List<Artikel> artikels){
        return artikels.stream()
//                .mapToDouble(a -> a.getPreis())
                .mapToDouble(Artikel::getPreis)
                .sum();
    }

    //Teuerster Artikel
    public static Optional<Artikel> getMostExpensiveArticle(List<Artikel>artikel){
        return artikel.stream()
                .max(Comparator.comparingDouble(Artikel::getPreis));
    }
}
