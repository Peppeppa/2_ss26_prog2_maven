# Java Stream API – Syntax-Rundown

> Kompakte Übersicht zur Java Stream API mit Fokus auf `List`, `Set`, `Map`, Generics, `Predicate`, `Function` und `Comparator`.

---

## Inhaltsverzeichnis

1. [Grundform eines Streams](#1-grundform-eines-streams)
2. [`filter(...)`](#2-filter)
3. [`map(...)`](#3-map)
4. [`forEach(...)`](#4-foreach)
5. [`sorted()`](#5-sorted)
6. [`count()`](#6-count)
7. [`toList()`](#7-tolist)
8. [`collect(Collectors.toSet())`](#8-collectcollectorstoset)
9. [`distinct()`](#9-distinct)
10. [`min(...)` und `max(...)`](#10-min-und-max)
11. [`Optional<T>`](#11-optionalt)
12. [`mapToInt`, `mapToDouble`, `sum`, `average`](#12-maptoint-maptodouble-sum-average)
13. [`Collectors.toMap(...)`](#13-collectorstomap)
14. [`groupingBy(...)`](#14-groupingby)
15. [`groupingBy(..., counting())`](#15-groupingby-counting)
16. [Generische Filter-Methode](#16-generische-filter-methode)
17. [Generische Map-Methode](#17-generische-map-methode)
18. [Generische Sortier-Methode](#18-generische-sortier-methode)
19. [`findFirst()`](#19-findfirst)
20. [`anyMatch`, `allMatch`, `noneMatch`](#20-anymatch-allmatch-nonematch)
21. [`reduce(...)`](#21-reduce)
22. [`flatMap(...)`](#22-flatmap)
23. [Typische Import-Liste](#23-typische-import-liste)
24. [Typische Muster für Klausuraufgaben](#24-typische-muster-für-klausuraufgaben)
25. [Wichtigster Merksatz](#25-wichtigster-merksatz)

---

## 1. Grundform eines Streams

Aus einer Liste wird ein Stream erzeugt. Danach folgen beliebig viele Zwischenoperationen und am Ende genau eine Endoperation.

```java
list.stream()
    .operation1(...)
    .operation2(...)
    .terminalOperation();
```

### Beispiel

```java
List<String> result = names.stream()
        .filter(name -> name.length() > 3)
        .toList();
```

### Wichtig

| Ausdruck                                 | Bedeutung           |
| ---------------------------------------- | ------------------- |
| `stream()`                               | startet den Stream  |
| `filter(...)`, `map(...)`, `sorted(...)` | Zwischenoperationen |
| `toList()`, `count()`, `forEach(...)`    | Endoperationen      |

---

## 2. `filter(...)`

`filter` behält nur Elemente, die eine Bedingung erfüllen.

```java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .toList();
```

### Allgemeine Form

```java
.filter(element -> bedingung)
```

### Beispiele

```java
.filter(s -> s.length() > 5)

.filter(student -> student.getNote() <= 2.0)

.filter(artikel -> artikel.getPreis() > 10.0)
```

### Merke

`filter` erwartet intern ein `Predicate<T>`.

```java
Predicate<T>
```

Das bedeutet:

```text
T -> boolean
```

---

## 3. `map(...)`

`map` wandelt jedes Element in etwas anderes um.

```java
List<String> names = students.stream()
        .map(student -> student.getName())
        .toList();
```

### Kürzer mit Methodenreferenz

```java
List<String> names = students.stream()
        .map(Student::getName)
        .toList();
```

### Allgemeine Form

```java
.map(element -> neuerWert)
```

### Beispiele

```java
.map(s -> s.toUpperCase())

.map(student -> student.getName())

.map(artikel -> artikel.getPreis())
```

### Merke

`map` erwartet intern eine `Function<T, R>`.

```java
Function<T, R>
```

Das bedeutet:

```text
T -> R
```

Beispiele:

```text
Student -> String
Artikel -> Double
String  -> Integer
```

---

## 4. `forEach(...)`

`forEach` führt eine Aktion für jedes Element aus.

```java
names.stream()
        .forEach(name -> System.out.println(name));
```

### Kürzer

```java
names.stream()
        .forEach(System.out::println);
```

> `forEach` gibt nichts zurück. Es ist eine Endoperation.

---

## 5. `sorted()`

`sorted()` sortiert Elemente alphabetisch oder nach ihrer natürlichen Ordnung.

```java
List<String> sortedNames = names.stream()
        .sorted()
        .toList();
```

### Objekte sortieren mit `Comparator`

Nach Name:

```java
List<Student> result = students.stream()
        .sorted(Comparator.comparing(Student::getName))
        .toList();
```

Nach `int`:

```java
List<Student> result = students.stream()
        .sorted(Comparator.comparingInt(Student::getAlter))
        .toList();
```

Nach `double`:

```java
List<Student> result = students.stream()
        .sorted(Comparator.comparingDouble(Student::getNote))
        .toList();
```

Absteigend:

```java
List<Student> result = students.stream()
        .sorted(Comparator.comparingInt(Student::getAlter).reversed())
        .toList();
```

---

## 6. `count()`

`count()` zählt Elemente.

```java
long count = names.stream()
        .filter(name -> name.length() > 5)
        .count();
```

> Rückgabetyp ist `long`, nicht `int`.

---

## 7. `toList()`

`toList()` macht aus dem Stream wieder eine Liste.

```java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .toList();
```

### Ältere Java-Versionen

Falls eine ältere Java-Version genutzt wird:

```java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .collect(Collectors.toList());
```

Dafür wird dieser Import benötigt:

```java
import java.util.stream.Collectors;
```

---

## 8. `collect(Collectors.toSet())`

Mit `Collectors.toSet()` kann aus einem Stream ein `Set` gebaut werden.

```java
Set<String> studiengaenge = students.stream()
        .map(Student::getStudiengang)
        .collect(Collectors.toSet());
```

> Ein `Set` entfernt Duplikate automatisch.

---

## 9. `distinct()`

`distinct()` entfernt Duplikate aus einem Stream.

```java
List<String> result = names.stream()
        .distinct()
        .toList();
```

### Beispiel

```text
["Anna", "Ben", "Anna"] -> ["Anna", "Ben"]
```

---

## 10. `min(...)` und `max(...)`

Mit `min(...)` und `max(...)` können kleinste oder größte Elemente gefunden werden.

### Kleinsten Wert finden

```java
Optional<Student> best = students.stream()
        .min(Comparator.comparingDouble(Student::getNote));
```

### Größten Wert finden

```java
Optional<Artikel> teuerster = artikel.stream()
        .max(Comparator.comparingDouble(Artikel::getPreis));
```

> Das Ergebnis ist ein `Optional<T>`, weil die Liste leer sein könnte.

---

## 11. `Optional<T>`

Ein `Optional<T>` kann einen Wert enthalten oder leer sein.

```java
Optional<Student> best = students.stream()
        .min(Comparator.comparingDouble(Student::getNote));
```

### Prüfen mit `isPresent()`

```java
if (best.isPresent()) {
    System.out.println(best.get());
}
```

### Besser: `ifPresent(...)`

```java
best.ifPresent(System.out::println);
```

### Standardwert mit `orElse(...)`

```java
Student result = best.orElse(null);
```

---

## 12. `mapToInt`, `mapToDouble`, `sum`, `average`

Für Zahlenberechnungen verwendet man oft spezielle Streams.

### Summe von Preisen

```java
double summe = artikel.stream()
        .mapToDouble(Artikel::getPreis)
        .sum();
```

### Durchschnittsnote

```java
double durchschnitt = students.stream()
        .mapToDouble(Student::getNote)
        .average()
        .orElse(0.0);
```

### Durchschnittsalter

```java
double durchschnitt = students.stream()
        .mapToInt(Student::getAlter)
        .average()
        .orElse(0.0);
```

### Warum `orElse(0.0)`?

Bei einer leeren Liste existiert kein Durchschnitt. Deshalb wird ein Standardwert angegeben.

---

## 13. `Collectors.toMap(...)`

Mit `Collectors.toMap(...)` kann eine Liste in eine Map umgewandelt werden.

```java
Map<String, Student> map = students.stream()
        .collect(Collectors.toMap(
                Student::getName,
                student -> student
        ));
```

### Bedeutung

| Teil                 | Bedeutung |
| -------------------- | --------- |
| `Student::getName`   | Key       |
| `student -> student` | Value     |

### Beispiel mit Artikeln

```java
Map<String, Artikel> map = artikel.stream()
        .collect(Collectors.toMap(
                Artikel::getName,
                artikelObjekt -> artikelObjekt
        ));
```

### Kürzer mit `Function.identity()`

```java
Map<String, Student> map = students.stream()
        .collect(Collectors.toMap(
                Student::getName,
                Function.identity()
        ));
```

Dafür wird dieser Import benötigt:

```java
import java.util.function.Function;
```

---

## 14. `groupingBy(...)`

Mit `groupingBy(...)` wird nach einem Merkmal gruppiert.

```java
Map<String, List<Student>> gruppiert = students.stream()
        .collect(Collectors.groupingBy(Student::getStudiengang));
```

### Ergebnis

```text
"Informatik" -> Liste von Informatikstudenten
"BWL"        -> Liste von BWL-Studenten
```

### Artikel nach Kategorie gruppieren

```java
Map<String, List<Artikel>> gruppiert = artikel.stream()
        .collect(Collectors.groupingBy(Artikel::getKategorie));
```

---

## 15. `groupingBy(..., counting())`

Mit `groupingBy(..., Collectors.counting())` wird pro Gruppe gezählt.

```java
Map<String, Long> count = students.stream()
        .collect(Collectors.groupingBy(
                Student::getStudiengang,
                Collectors.counting()
        ));
```

### Ergebnis

```text
"Informatik" -> 3
"BWL"        -> 2
```

---

## 16. Generische Filter-Methode

```java
public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
    return list.stream()
            .filter(predicate)
            .toList();
}
```

Benötigter Import:

```java
import java.util.function.Predicate;
```

### Verwendung

```java
List<String> langeNamen = filterList(names, name -> name.length() > 5);
```

```java
List<Student> informatik = filterList(students,
        student -> student.getStudiengang().equals("Informatik"));
```

---

## 17. Generische Map-Methode

```java
public static <T, R> List<R> mapList(List<T> list, Function<T, R> function) {
    return list.stream()
            .map(function)
            .toList();
}
```

Benötigter Import:

```java
import java.util.function.Function;
```

### Verwendung

```java
List<String> namen = mapList(students, Student::getName);
```

```java
List<Integer> laengen = mapList(names, String::length);
```

### Bedeutung von `<T, R>`

| Typ  | Bedeutung   |
| ---- | ----------- |
| `T`  | Eingangstyp |
| `R`  | Rückgabetyp |

---

## 18. Generische Sortier-Methode

```java
public static <T> List<T> sortList(List<T> list, Comparator<T> comparator) {
    return list.stream()
            .sorted(comparator)
            .toList();
}
```

### Verwendung

```java
List<Student> sortiert = sortList(students,
        Comparator.comparing(Student::getName));
```

```java
List<Artikel> sortiert = sortList(artikel,
        Comparator.comparingDouble(Artikel::getPreis));
```

---

## 19. `findFirst()`

`findFirst()` findet das erste passende Element.

```java
Optional<Student> result = students.stream()
        .filter(student -> student.getNote() <= 2.0)
        .findFirst();
```

### Generische Variante

```java
public static <T> Optional<T> findFirstMatching(List<T> list, Predicate<T> predicate) {
    return list.stream()
            .filter(predicate)
            .findFirst();
}
```

---

## 20. `anyMatch`, `allMatch`, `noneMatch`

Diese Methoden prüfen Bedingungen auf dem Stream.

| Methode          | Bedeutung                    |
| ---------------- | ---------------------------- |
| `anyMatch(...)`  | mindestens ein Element passt |
| `allMatch(...)`  | alle Elemente passen         |
| `noneMatch(...)` | kein Element passt           |

### Mindestens eins passt

```java
boolean result = students.stream()
        .anyMatch(student -> student.getNote() <= 2.0);
```

### Alle passen

```java
boolean result = students.stream()
        .allMatch(student -> student.getAlter() >= 18);
```

### Keins passt

```java
boolean result = students.stream()
        .noneMatch(student -> student.getNote() == 5.0);
```

---

## 21. `reduce(...)`

`reduce(...)` fasst mehrere Werte zu einem Wert zusammen.

### Summe mit `reduce`

```java
int summe = numbers.stream()
        .reduce(0, (a, b) -> a + b);
```

### Kürzer

```java
int summe = numbers.stream()
        .reduce(0, Integer::sum);
```

### Wörter verbinden

```java
String text = words.stream()
        .reduce("", (a, b) -> a + " " + b);
```

> Das kann am Anfang ein führendes Leerzeichen erzeugen. Sauberer wäre `Collectors.joining(...)`, aber wenn `reduce` geübt werden soll, ist das Prinzip wichtig.

---

## 22. `flatMap(...)`

`flatMap(...)` macht verschachtelte Strukturen flach.

### Liste von Listen

```java
List<List<String>> lists = ...;
```

Daraus wird eine flache Liste:

```java
List<String> result = lists.stream()
        .flatMap(list -> list.stream())
        .toList();
```

### Kürzer

```java
List<String> result = lists.stream()
        .flatMap(List::stream)
        .toList();
```

### Sätze in Wörter zerlegen

```java
List<String> words = sentences.stream()
        .map(sentence -> sentence.split(" "))
        .flatMap(array -> Arrays.stream(array))
        .toList();
```

Benötigter Import:

```java
import java.util.Arrays;
```

---

## 23. Typische Import-Liste

### Einzelne Imports

```java
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
```

### Für Übungen oft ausreichend

```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
```

---

## 24. Typische Muster für Klausuraufgaben

### Filtern, sortieren und zurückgeben

```java
return list.stream()
        .filter(x -> ...)
        .sorted(...)
        .toList();
```

### Filtern und Attribut extrahieren

```java
return students.stream()
        .filter(s -> s.getNote() <= 2.0)
        .map(Student::getName)
        .toList();
```

### Filtern und zählen

```java
return students.stream()
        .filter(s -> s.getStudiengang().equals("Informatik"))
        .count();
```

### Gruppieren

```java
return students.stream()
        .collect(Collectors.groupingBy(Student::getStudiengang));
```

### In Map umwandeln

```java
return students.stream()
        .collect(Collectors.toMap(
                Student::getName,
                Function.identity()
        ));
```

---

## 25. Wichtigster Merksatz

| Operation     | Bedeutung                                  |
| ------------- | ------------------------------------------ |
| `filter`      | behält oder entfernt Elemente              |
| `map`         | wandelt Elemente um                        |
| `sorted`      | sortiert Elemente                          |
| `collect`     | sammelt in `List`, `Set` oder `Map`        |
| `count`       | zählt Elemente                             |
| `min` / `max` | sucht kleinstes oder größtes Element       |
| `reduce`      | fasst mehrere Werte zu einem Wert zusammen |
| `flatMap`     | macht verschachtelte Listen flach          |

Der Kern sieht fast immer so aus:

```java
return liste.stream()
        .filter(...)
        .map(...)
        .sorted(...)
        .toList();
```