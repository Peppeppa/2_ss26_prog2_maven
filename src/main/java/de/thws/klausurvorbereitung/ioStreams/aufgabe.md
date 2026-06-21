Level 1: Grundlagen FileReader, FileWriter
Aufgabe 1: Datei zeichenweise auslesen

Schreibe eine Methode:

public static void printFile(String path)

Die Methode soll eine Textdatei öffnen und ihren Inhalt zeichenweise auf der Konsole ausgeben.

Verwende:

FileReader
try-catch-finally
close()

Übungsziel:

Datei öffnen
zeichenweise lesen
EOF erkennen
Datei schließen
IOException behandeln

Wichtig: Verwende hier absichtlich noch kein try-with-resources.

Aufgabe 2: Text in Datei schreiben

Schreibe eine Methode:

public static void writeText(String path, String text)

Die Methode soll den übergebenen Text in eine Datei schreiben.

Verwende:

FileWriter
try-catch-finally
close()

Teste auch, was passiert, wenn die Datei vorher schon existiert.

Übungsziel:

Datei zum Schreiben öffnen
Text schreiben
Writer schließen
IOException behandeln
Aufgabe 3: Text an Datei anhängen

Schreibe eine Methode:

public static void appendText(String path, String text)

Die Methode soll den Text nicht überschreiben, sondern hinten an die Datei anhängen.

Verwende:

FileWriter
append-Modus
try-with-resources

Hinweis: Der FileWriter hat einen Konstruktor, mit dem man Anhängen aktivieren kann.

Level 2: Buffered Reader / Writer
Aufgabe 4: Datei zeilenweise lesen

Schreibe eine Methode:

public static void printLines(String path)

Die Methode soll eine Textdatei zeilenweise ausgeben.

Verwende:

FileReader
BufferedReader
try-with-resources
readLine()

Übungsziel:

Reader verschachteln
BufferedReader korrekt nutzen
null als Dateiende verstehen
automatisches Schließen durch try-with-resources
Aufgabe 5: Zeilen nummeriert ausgeben

Schreibe eine Methode:

public static void printLinesWithNumbers(String path)

Beispielausgabe:

1: erste Zeile
2: zweite Zeile
3: dritte Zeile

Verwende:

BufferedReader
FileReader
readLine()

Übungsziel:

Datei lesen
Zähler verwalten
zeilenweise Verarbeitung
Aufgabe 6: Liste von Strings in Datei schreiben

Schreibe eine Methode:

public static void writeLines(String path, List<String> lines)

Die Methode soll jede Zeichenkette aus der Liste als eigene Zeile in die Datei schreiben.

Verwende:

FileWriter
BufferedWriter
newLine()
try-with-resources

Übungsziel:

Writer verschachteln
Zeilenumbruch plattformunabhängig schreiben
Liste durchlaufen
Level 3: Kopieren und Umwandeln
Aufgabe 7: Textdatei kopieren

Schreibe eine Methode:

public static void copyTextFile(String sourcePath, String targetPath)

Die Methode soll eine Textdatei zeilenweise kopieren.

Verwende:

BufferedReader
FileReader
BufferedWriter
FileWriter
try-with-resources

Übungsziel:

gleichzeitig lesen und schreiben
zwei Ressourcen in einem try-with-resources öffnen
korrekt schließen
Aufgabe 8: Datei kopieren und Zeilen in Großbuchstaben schreiben

Schreibe eine Methode:

public static void copyUpperCase(String sourcePath, String targetPath)

Die Methode soll eine Textdatei lesen und in eine neue Datei schreiben, aber alle Zeilen in Großbuchstaben umwandeln.

Verwende:

BufferedReader
BufferedWriter
String.toUpperCase()

Übungsziel:

lesen
verarbeiten
schreiben
Aufgabe 9: Leere Zeilen entfernen

Schreibe eine Methode:

public static void removeEmptyLines(String sourcePath, String targetPath)

Die Methode soll eine Textdatei kopieren, aber leere Zeilen nicht übernehmen.

Eine Zeile gilt als leer, wenn nach trim() nichts mehr übrig bleibt.

Verwende:

BufferedReader
BufferedWriter
trim()
isEmpty()
Level 4: Byte Streams
Aufgabe 10: Binärdatei kopieren

Schreibe eine Methode:

public static void copyBinaryFile(String sourcePath, String targetPath)

Die Methode soll beliebige Dateien kopieren können, also auch Bilder, PDFs oder ZIP-Dateien.

Verwende:

FileInputStream
FileOutputStream
byte[]
read(byte[])
write(byte[], int, int)
try-with-resources

Übungsziel:

Unterschied zwischen Reader/Writer und InputStream/OutputStream verstehen
Puffer verwenden
binäre Daten korrekt kopieren

Wichtig: Hier keinen FileReader verwenden.

Aufgabe 11: Datei-Bytes zählen

Schreibe eine Methode:

public static long countBytes(String path)

Die Methode soll zurückgeben, wie viele Bytes eine Datei enthält.

Verwende:

FileInputStream
read()
oder read(byte[])

Übungsziel:

Byte Stream öffnen
bis Dateiende lesen
long als Zähler verwenden
Level 5: Encoding und Brückenklassen
Aufgabe 12: Textdatei mit UTF-8 lesen

Schreibe eine Methode:

public static void printUtf8File(String path)

Die Methode soll eine Textdatei mit UTF-8-Encoding lesen.

Verwende:

FileInputStream
InputStreamReader
BufferedReader
StandardCharsets.UTF_8

Übungsziel:

Byte Stream zu Character Stream machen
Encoding explizit angeben
Reader verschachteln

Struktur, die du üben sollst:

FileInputStream
-> InputStreamReader
-> BufferedReader
Aufgabe 13: Textdatei mit UTF-8 schreiben

Schreibe eine Methode:

public static void writeUtf8File(String path, List<String> lines)

Die Methode soll mehrere Zeilen mit UTF-8-Encoding schreiben.

Verwende:

FileOutputStream
OutputStreamWriter
BufferedWriter
StandardCharsets.UTF_8

Struktur:

FileOutputStream
-> OutputStreamWriter
-> BufferedWriter
Level 6: Fehlerbehandlung bewusst üben
Aufgabe 14: Datei sicher lesen mit eigener Fehlermeldung

Schreibe eine Methode:

public static void safePrintFile(String path)

Die Methode soll versuchen, eine Datei zu lesen.

Falls die Datei nicht existiert, soll ausgegeben werden:

Datei wurde nicht gefunden.

Falls ein anderer I/O-Fehler passiert:

Fehler beim Lesen der Datei.

Verwende:

FileNotFoundException
IOException
mehrere catch-Blöcke

Wichtig: Die speziellere Exception muss vor der allgemeineren Exception stehen.

Aufgabe 15: Methode mit throws

Schreibe eine Methode:

public static String readFirstLine(String path) throws IOException

Die Methode soll die erste Zeile einer Datei zurückgeben.

In dieser Methode sollst du die Exception nicht selbst behandeln, sondern mit throws IOException weitergeben.

Übungsziel:

Unterschied zwischen try-catch und throws verstehen
Level 7: Kleine Prüfungsaufgaben
Aufgabe 16: Anzahl der Zeilen zählen

Schreibe eine Methode:

public static int countLines(String path)

Sie soll die Anzahl der Zeilen in einer Textdatei zurückgeben.

Verwende:

BufferedReader
readLine()
try-with-resources
Aufgabe 17: Wort in Datei suchen

Schreibe eine Methode:

public static boolean containsWord(String path, String word)

Die Methode soll true zurückgeben, wenn das Wort irgendwo in der Datei vorkommt.

Verwende:

BufferedReader
String.contains()
Aufgabe 18: Alle Zeilen mit bestimmtem Wort zurückgeben

Schreibe eine Methode:

public static List<String> findLinesContaining(String path, String word)

Die Methode soll alle Zeilen zurückgeben, in denen word vorkommt.

Verwende:

List<String>
ArrayList
BufferedReader
Aufgabe 19: Datei filtern

Schreibe eine Methode:

public static void filterLines(String sourcePath, String targetPath, String word)

Die Methode soll nur die Zeilen in die Zieldatei schreiben, die word enthalten.

Verwende:

BufferedReader
BufferedWriter
String.contains()
Aufgabe 20: CSV-Datei einfach auswerten

Eine Datei enthält Zeilen im Format:

Anna;22
Ben;19
Clara;25

Schreibe eine Methode:

public static Map<String, Integer> readAges(String path)

Die Methode soll eine Map<String, Integer> zurückgeben.

Beispiel:

"Anna" -> 22
"Ben" -> 19
"Clara" -> 25

Verwende:

BufferedReader
HashMap
String.split(";")
Integer.parseInt()
Reihenfolge zum Üben

Ich würde sie in dieser Reihenfolge machen:

1, 2, 4, 6, 7, 10, 12, 14, 15, 20

Damit deckst du fast alles ab:

FileReader/FileWriter
BufferedReader/BufferedWriter
try-catch-finally
try-with-resources
Reader/Writer-Verschachtelung
InputStream/OutputStream
Encoding
throws
Map aus Datei bauen