package de.thws.klausurvorbereitung.StreamingAPI.streams;


import java.util.*;

public class Level2 {

    // Studenten nach Studiengang filtern
    public static List<Student> getStudentsByStudiengang(List<Student> students, String studiengang) {
        return students.stream()
                .filter(student -> student.getStudiengang().equals(studiengang))
                .toList();
    }

    // Namen aller Studenten extrahieren
    public static List<String> getStudentNames(List<Student> students) {
        return students.stream()
                .map(student -> student.getName())
                .toList();
    }

    // Studenten nach Note sortieren
    public static List<Student> sortByNote(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingDouble(student -> student.getNote()))
                .toList();
    }

    // Studenten nach Alter absteigend sortieren
    public static List<Student> sortByAgeDescending(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getAlter(), s1.getAlter()))
                .toList();
    }

    // Bester Student
    public static Optional<Student> getBestStudent(List<Student> students) {
        return students.stream()
                .min(Comparator.comparingDouble(student -> student.getNote()));
    }
}
