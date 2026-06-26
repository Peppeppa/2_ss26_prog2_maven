# Übungsset: Java Stream API

Ein Übungsset für die **Java Stream API**, ähnlich aufgebaut wie die I/O-Aufgaben: kleine Methoden, keine ganzen Projekte.

## Fokus

- `List`, `Set`, `Map`
- `filter`, `map`, `sorted`, `collect`, `reduce`
- `Comparator`
- `Optional`
- Generics
- `Predicate` / `Function`
- Collections umwandeln

> **Regel für die Aufgaben:** Benutze möglichst keine klassischen `for`-Schleifen, sondern Streams.

---

# Vorgegebene Klassen

## `Student.java`

```java
package de.thws.klausurvorbereitung.streams;

public class Student {

    private String name;
    private int alter;
    private String studiengang;
    private double note;

    public Student(String name, int alter, String studiengang, double note) {
        this.name = name;
        this.alter = alter;
        this.studiengang = studiengang;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getStudiengang() {
        return studiengang;
    }

    public double getNote() {
        return note;
    }

    @Override
    public String toString() {
        return name + " (" + alter + ", " + studiengang + ", " + note + ")";
    }
}
```

## `Artikel.java`

```java
package de.thws.klausurvorbereitung.streams;

public class Artikel {

    private String name;
    private String kategorie;
    private double preis;

    public Artikel(String name, String kategorie, double preis) {
        this.name = name;
        this.kategorie = kategorie;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public String getKategorie() {
        return kategorie;
    }

    public double getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return name + " (" + kategorie + ", " + preis + ")";
    }
}
```

---

# Level 1: Streams mit `List<String>`

## Aufgabe 1: Alle Namen ausgeben

Schreibe eine Methode:

```java
public static void printAll(List<String> names)
```

Die Methode soll alle Namen mit `forEach` ausgeben.

**Verwende:**

- `stream()`
- `forEach()`

## Aufgabe 2: Namen filtern

Schreibe eine Methode:

```java
public static List<String> namesStartingWith(List<String> names, String prefix)
```

Die Methode soll nur die Namen zurückgeben, die mit `prefix` beginnen.

**Verwende:**

- `filter()`
- `startsWith()`
- `toList()`

## Aufgabe 3: Namen in Großbuchstaben

Schreibe eine Methode:

```java
public static List<String> toUpperCase(List<String> names)
```

Die Methode soll alle Namen in Großbuchstaben umwandeln.

**Verwende:**

- `map()`
- `String.toUpperCase()`

## Aufgabe 4: Namen alphabetisch sortieren

Schreibe eine Methode:

```java
public static List<String> sortNames(List<String> names)
```

Die Methode soll eine alphabetisch sortierte Liste zurückgeben.

**Verwende:**

- `sorted()`

## Aufgabe 5: Anzahl langer Namen

Schreibe eine Methode:

```java
public static long countLongNames(List<String> names, int minLength)
```

Die Methode soll zählen, wie viele Namen mindestens `minLength` Zeichen lang sind.

**Verwende:**

- `filter()`
- `count()`

---

# Level 2: Streams mit Objekten

## Aufgabe 6: Studenten nach Studiengang filtern

Schreibe eine Methode:

```java
public static List<Student> getStudentsByStudiengang(List<Student> students, String studiengang)
```

Die Methode soll alle Studenten aus einem bestimmten Studiengang zurückgeben.

**Verwende:**

- `filter()`
- `equals()`
- `toList()`

## Aufgabe 7: Namen aller Studenten extrahieren

Schreibe eine Methode:

```java
public static List<String> getStudentNames(List<Student> students)
```

Die Methode soll nur die Namen der Studenten zurückgeben.

**Verwende:**

- `map()`
- `getName()`

## Aufgabe 8: Studenten nach Note sortieren

Schreibe eine Methode:

```java
public static List<Student> sortByNote(List<Student> students)
```

Die Methode soll Studenten aufsteigend nach Note sortieren.

**Verwende:**

- `sorted()`
- `Comparator.comparingDouble()`

## Aufgabe 9: Studenten nach Alter absteigend sortieren

Schreibe eine Methode:

```java
public static List<Student> sortByAgeDescending(List<Student> students)
```

Die Methode soll Studenten absteigend nach Alter sortieren.

**Verwende:**

- `Comparator.comparingInt()`
- `reversed()`

## Aufgabe 10: Bester Student

Schreibe eine Methode:

```java
public static Optional<Student> getBestStudent(List<Student> students)
```

Die beste Note ist die kleinste Zahl.

**Verwende:**

- `min()`
- `Comparator.comparingDouble()`
- `Optional`

---

# Level 3: Berechnungen mit Streams

## Aufgabe 11: Durchschnittsnote berechnen

Schreibe eine Methode:

```java
public static double getAverageGrade(List<Student> students)
```

Die Methode soll die Durchschnittsnote berechnen.

Falls die Liste leer ist, soll `0.0` zurückgegeben werden.

**Verwende:**

- `mapToDouble()`
- `average()`
- `orElse()`

## Aufgabe 12: Durchschnittsalter berechnen

Schreibe eine Methode:

```java
public static double getAverageAge(List<Student> students)
```

**Verwende:**

- `mapToInt()`
- `average()`
- `orElse()`

## Aufgabe 13: Summe aller Artikelpreise

Schreibe eine Methode:

```java
public static double sumPrices(List<Artikel> artikel)
```

Die Methode soll die Summe aller Preise berechnen.

**Verwende:**

- `mapToDouble()`
- `sum()`

## Aufgabe 14: Teuerster Artikel

Schreibe eine Methode:

```java
public static Optional<Artikel> getMostExpensiveArticle(List<Artikel> artikel)
```

**Verwende:**

- `max()`
- `Comparator.comparingDouble()`
- `Optional`

---

# Level 4: Set, Duplikate und `distinct`

## Aufgabe 15: Doppelte Namen entfernen

Schreibe eine Methode:

```java
public static List<String> removeDuplicates(List<String> names)
```

Die Methode soll doppelte Namen entfernen.

**Verwende:**

- `distinct()`
- `toList()`

## Aufgabe 16: Studiengänge als Set zurückgeben

Schreibe eine Methode:

```java
public static Set<String> getStudiengaenge(List<Student> students)
```

Die Methode soll alle vorkommenden Studiengänge zurückgeben.

**Verwende:**

- `map()`
- `collect(Collectors.toSet())`

## Aufgabe 17: Kategorien aller Artikel

Schreibe eine Methode:

```java
public static Set<String> getKategorien(List<Artikel> artikel)
```

Die Methode soll alle Kategorien ohne Duplikate zurückgeben.

**Verwende:**

- `map()`
- `collect(Collectors.toSet())`

---

# Level 5: Map mit Streams

## Aufgabe 18: Studenten nach Name in Map speichern

Schreibe eine Methode:

```java
public static Map<String, Student> mapStudentsByName(List<Student> students)
```

Die Methode soll eine Map erzeugen:

```text
Name -> Student
```

**Verwende:**

- `collect()`
- `Collectors.toMap()`

## Aufgabe 19: Artikel nach Name in Map speichern

Schreibe eine Methode:

```java
public static Map<String, Artikel> mapArtikelByName(List<Artikel> artikel)
```

Die Methode soll eine Map erzeugen:

```text
Artikelname -> Artikel
```

## Aufgabe 20: Anzahl Studenten pro Studiengang

Schreibe eine Methode:

```java
public static Map<String, Long> countStudentsByStudiengang(List<Student> students)
```

Die Methode soll zählen, wie viele Studenten es pro Studiengang gibt.

**Beispiel:**

```text
Informatik -> 3
BWL        -> 2
Design     -> 1
```

**Verwende:**

- `Collectors.groupingBy()`
- `Collectors.counting()`

## Aufgabe 21: Artikel nach Kategorie gruppieren

Schreibe eine Methode:

```java
public static Map<String, List<Artikel>> groupArticlesByCategory(List<Artikel> artikel)
```

Die Methode soll Artikel nach Kategorie gruppieren.

**Beispiel:**

```text
Lebensmittel -> [Brot, Milch]
Technik      -> [Maus, Tastatur]
```

**Verwende:**

- `Collectors.groupingBy()`

---

# Level 6: Generische Methoden mit Streams

Jetzt wird es wichtiger für Generics.

## Aufgabe 22: Generische Filter-Methode

Schreibe eine Methode:

```java
public static <T> List<T> filterList(List<T> list, Predicate<T> predicate)
```

Die Methode soll alle Elemente zurückgeben, für die das Predicate `true` liefert.

**Verwende:**

- `<T>`
- `Predicate<T>`
- `filter()`
- `toList()`

**Beispielhafte Verwendung später:**

- Strings länger als 5 Zeichen
- Studenten aus Informatik
- Artikel teurer als 10 Euro

## Aufgabe 23: Generische Map-Methode

Schreibe eine Methode:

```java
public static <T, R> List<R> mapList(List<T> list, Function<T, R> function)
```

Die Methode soll Elemente vom Typ `T` in Elemente vom Typ `R` umwandeln.

**Verwende:**

- `<T, R>`
- `Function<T, R>`
- `map()`
- `toList()`

**Beispielhafte Verwendung später:**

- `Student -> String`
- `Artikel -> Double`
- `String -> Integer`

## Aufgabe 24: Generische Sortier-Methode

Schreibe eine Methode:

```java
public static <T> List<T> sortList(List<T> list, Comparator<T> comparator)
```

Die Methode soll eine sortierte neue Liste zurückgeben.

Die ursprüngliche Liste soll nicht verändert werden.

**Verwende:**

- `<T>`
- `Comparator<T>`
- `stream()`
- `sorted()`
- `toList()`

## Aufgabe 25: Erstes passendes Element finden

Schreibe eine Methode:

```java
public static <T> Optional<T> findFirstMatching(List<T> list, Predicate<T> predicate)
```

Die Methode soll das erste Element zurückgeben, das zur Bedingung passt.

**Verwende:**

- `filter()`
- `findFirst()`
- `Optional<T>`

## Aufgabe 26: Prüfen, ob irgendein Element passt

Schreibe eine Methode:

```java
public static <T> boolean anyMatches(List<T> list, Predicate<T> predicate)
```

**Verwende:**

- `anyMatch()`
- `Predicate<T>`

## Aufgabe 27: Prüfen, ob alle Elemente passen

Schreibe eine Methode:

```java
public static <T> boolean allMatch(List<T> list, Predicate<T> predicate)
```

**Verwende:**

- `allMatch()`
- `Predicate<T>`

---

# Level 7: `reduce`

## Aufgabe 28: Summe mit `reduce`

Schreibe eine Methode:

```java
public static int sumNumbers(List<Integer> numbers)
```

Die Methode soll die Summe aller Zahlen mit `reduce` berechnen.

**Verwende:**

- `reduce()`

## Aufgabe 29: Alle Wörter verbinden

Schreibe eine Methode:

```java
public static String joinWords(List<String> words)
```

Die Methode soll alle Wörter zu einem String verbinden.

**Beispiel:**

```java
List.of("Java", "ist", "gut")
```

Ergebnis:

```text
Java ist gut
```

**Verwende:**

- `reduce()`

## Aufgabe 30: Längstes Wort finden

Schreibe eine Methode:

```java
public static Optional<String> findLongestWord(List<String> words)
```

**Verwende:**

- `reduce()`
- `Optional`

---

# Level 8: `flatMap`

## Aufgabe 31: Listen zusammenführen

Schreibe eine Methode:

```java
public static List<String> flatten(List<List<String>> lists)
```

Die Methode soll aus mehreren Listen eine flache Liste machen.

**Beispiel:**

```java
List.of(
    List.of("A", "B"),
    List.of("C"),
    List.of("D", "E")
)
```

Ergebnis:

```java
List.of("A", "B", "C", "D", "E")
```

**Verwende:**

- `flatMap()`

## Aufgabe 32: Alle Wörter aus Sätzen extrahieren

Schreibe eine Methode:

```java
public static List<String> getWords(List<String> sentences)
```

**Beispiel:**

```java
List.of("Java ist gut", "Streams sind praktisch")
```

Ergebnis:

```java
List.of("Java", "ist", "gut", "Streams", "sind", "praktisch")
```

**Verwende:**

- `map()`
- `split(" ")`
- `flatMap()`

---

# Level 9: Kombinierte Prüfungsaufgaben

## Aufgabe 33: Gute Informatikstudenten alphabetisch

Schreibe eine Methode:

```java
public static List<String> getGoodInformatikStudentNames(List<Student> students)
```

Die Methode soll:

1. nur Studenten aus `"Informatik"` nehmen,
2. nur Studenten mit Note `<= 2.0` nehmen,
3. nur deren Namen zurückgeben,
4. die Namen alphabetisch sortieren.

**Verwende:**

- `filter()`
- `filter()`
- `map()`
- `sorted()`
- `toList()`

## Aufgabe 34: Teure Artikel einer Kategorie sortieren

Schreibe eine Methode:

```java
public static List<Artikel> getExpensiveArticlesByCategory(
        List<Artikel> artikel,
        String kategorie,
        double minPreis
)
```

Die Methode soll:

1. nur Artikel aus der angegebenen Kategorie nehmen,
2. nur Artikel mit Preis `>= minPreis` nehmen,
3. nach Preis absteigend sortieren,
4. als Liste zurückgeben.

**Verwende:**

- `filter()`
- `Comparator.comparingDouble()`
- `reversed()`

## Aufgabe 35: Namen der ältesten Studenten

Schreibe eine Methode:

```java
public static List<String> getOldestStudentNames(List<Student> students)
```

Die Methode soll alle Namen der Studenten zurückgeben, die das höchste Alter in der Liste haben.

**Beispiel:**

```text
Anna  21
Ben   24
Clara 24
David 20
```

Ergebnis:

```java
List.of("Ben", "Clara")
```

> **Hinweis:** Diese Aufgabe darfst du in zwei Stream-Schritten lösen.

---

# Empfohlene Reihenfolge

Mach die Aufgaben am besten in dieser Reihenfolge:

```text
1, 2, 3, 4, 6, 7, 8, 10,
11, 13, 15, 16,
18, 20, 21,
22, 23, 24, 25,
28, 31, 33, 35
```

Damit übst du fast alles, was klausurrelevant ist:

- `stream()`
- `filter()`
- `map()`
- `sorted()`
- `collect()`
- `toList()`
- `Collectors.toSet()`
- `Collectors.toMap()`
- `Collectors.groupingBy()`
- `Optional`
- `Comparator`
- `Predicate<T>`
- `Function<T, R>`
- generische Methoden
- `reduce()`
- `flatMap()`

---

# Nächster Schritt

Fang am besten mit **Level 1** an und schick deine Lösungen. Sie können dann Schritt für Schritt korrigiert werden.