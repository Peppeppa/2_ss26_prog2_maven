package de.thws.lektion17.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class StreamMessung {
    public static void main(String[] args) {

        long zeit = copyByteweiseUngepuffert("test.mp3", "kopie1.mp3");
        System.out.println("Dauer: " + zeit + " ms");
        long zeit2 = copyByteweiseGepuffert("test.mp3", "kopie2.mp3");
        System.out.println("Gepuffert: " + zeit2 + " ms");
        long zeit3 = copyMitArray1024("test.mp3", "kopie3.mp3");
        System.out.println("Array 1024: " + zeit3 + " ns");


        long summe1 = 0;
        long summe2 = 0;
        long summe3 = 0;

        for (int i = 1; i <= 10; i++) {
            long zeit1s = copyByteweiseUngepuffert("test.mp3", "kopie1_" + i + ".mp3");
            long zeit2s = copyByteweiseGepuffert("test.mp3", "kopie2_" + i + ".mp3");
            long zeit3s = copyMitArray1024("test.mp3", "kopie3_" + i + ".mp3");

            summe1 = summe1 + zeit1s;
            summe2 = summe2 + zeit2s;
            summe3 = summe3 + zeit3s;

            System.out.println("Durchlauf " + i);
            System.out.println("Ungepuffert byteweise: " + zeit1s + " ms");
            System.out.println("Gepuffert byteweise:   " + zeit2s + " ms");
            System.out.println("Mit Array 1024:        " + zeit3s + " nanos");
            System.out.println();


        }
        double durchschnitt1 = summe1 / 10.0;
        double durchschnitt2 = summe2 / 10.0;
        double durchschnitt3 = summe3 / 10.0;

        System.out.println("Durchschnittswerte:");
        System.out.println("Ungepuffert byteweise: " + durchschnitt1 + " ms");
        System.out.println("Gepuffert byteweise:   " + durchschnitt2 + " ms");
        System.out.println("Mit Array 1024:        " + durchschnitt3 + " nanos");

        pruefeDateilaenge("test.mp3", "kopie1_1.mp3");
        pruefeDateilaenge("test.mp3", "kopie2_1.mp3");
        pruefeDateilaenge("test.mp3", "kopie3_1.mp3");
        double faktor12 = durchschnitt1 / durchschnitt2;
        double faktor13 = durchschnitt1 / durchschnitt3;
        double faktor32 = durchschnitt3 / durchschnitt2;

        System.out.println("Faktor ungepuffert/gepuffert: " + faktor12);
        System.out.println("Faktor ungepuffert/array1024: " + faktor13);
        System.out.println("Faktor array1024/gepuffert: " + faktor32);

        double prozent12 = ((durchschnitt1 - durchschnitt2) / durchschnitt1) * 100;
        double prozent13 = ((durchschnitt1 - durchschnitt3) / durchschnitt1) * 100;

        System.out.println("Gepuffert ist " + prozent12 + " % schneller als ungepuffert.");
        System.out.println("Array1024 ist " + prozent13 + " % schneller als ungepuffert.");

        pruefeDateilaenge("test.mp3", "kopie1_1.mp3");
        pruefeDateilaenge("test.mp3", "kopie2_1.mp3");
        pruefeDateilaenge("test.mp3", "kopie3_1.mp3");
    }

    public static long copyByteweiseUngepuffert(String quelle, String ziel) {
        long startZeit;
        long endZeit;

        try (
            FileInputStream in = new FileInputStream(quelle);
            FileOutputStream out = new FileOutputStream(ziel);){

            startZeit = System.currentTimeMillis();

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);

            }

            endZeit = System.currentTimeMillis();


            return endZeit-startZeit;

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + quelle);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben.");
        }
        return -1;
    }

    public static long copyByteweiseGepuffert(String quelle, String ziel){
        long startZeit;
        long endZeit;

        try (
            FileInputStream fis = new FileInputStream(quelle);
            FileOutputStream fos = new FileOutputStream(ziel);
            BufferedInputStream in = new BufferedInputStream(fis);
            BufferedOutputStream out = new BufferedOutputStream(fos);){

            startZeit = System.currentTimeMillis();

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }


            endZeit = System.currentTimeMillis();




            return endZeit - startZeit;

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + quelle);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben.");
        }

        return -1;
    }

    public static long copyMitArray1024(String quelle, String ziel){
        long startZeit;
        long endZeit;

        try (
            FileInputStream in = new FileInputStream(quelle);
            FileOutputStream out = new FileOutputStream(ziel);){

            byte[] buffer = new byte[1024];

            startZeit = System.nanoTime();

            int anzahl;
            while ((anzahl = in.read(buffer)) != -1) {
                out.write(buffer, 0, anzahl);
            }

            endZeit = System.nanoTime();

            return endZeit - startZeit;

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + quelle);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben.");
        }

        return -1;
    }

    public static void pruefeDateilaenge(String originalPfad, String kopiePfad) {
        File original = new File(originalPfad);
        File kopie = new File(kopiePfad);

        long originalLaenge = original.length();
        long kopieLaenge = kopie.length();

        System.out.println("Original: " + originalLaenge + " Bytes");
        System.out.println("Kopie:    " + kopieLaenge + " Bytes");

        if (originalLaenge == kopieLaenge) {
            System.out.println("Dateilängen sind gleich.");
        } else {
            System.out.println("Dateilängen sind NICHT gleich.");
        }
    }
}


