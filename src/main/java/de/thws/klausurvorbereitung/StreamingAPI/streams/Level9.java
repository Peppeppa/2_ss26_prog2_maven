package de.thws.klausurvorbereitung.StreamingAPI.streams;

import java.util.*;
public class Level9 {

    // Gute Informatikstudenten alphabetisch
    public static List<String> getGoodInformatikStudentNames(List<Student> students) {
        return students.stream()
                .filter(student -> student.getStudiengang().equals("Informatik"))
                .filter(student -> student.getNote() <= 2.0)
                .map(Student::getName)
                .sorted()
                .toList();
    }

    // Teure Artikel einer Kategorie sortieren
    public static List<Artikel> getExpensiveArticlesByCategory(
            List<Artikel> artikel,
            String kategorie,
            double minPreis
    ) {
        return artikel.stream()
                .filter(a -> a.getKategorie().equals(kategorie))
                .filter(a -> a.getPreis() >= minPreis)
                .sorted(Comparator.comparingDouble(Artikel::getPreis).reversed())
                .toList();
    }

    // Namen der ältesten Studenten
    public static List<String> getOldestStudentNames(List<Student> students) {
        int maxAlter = students.stream()
                .mapToInt(Student::getAlter)
                .max()
                .orElse(0);

        return students.stream()
                .filter(student -> student.getAlter() == maxAlter)
                .map(Student::getName)
                .toList();
    }
}