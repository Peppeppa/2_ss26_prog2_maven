package de.thws.lektion22.PrimzahlenListe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimzahlenListeMain {

    public static void main(String[] args) {

        ArrayList<Integer> liste1 = new ArrayList<>();
        liste1.add(341);
        liste1.add(17);
        liste1.add(19);

        ArrayList<Integer> liste2 = new ArrayList<>();
        liste2.add(633910099);
        liste2.add(21);
        liste2.add(97);

        ArrayList<Integer> liste3 = new ArrayList<>();
        liste3.add(2);
        liste3.add(1);
        liste3.add(100);

        PrimzahlThread thread1 = new PrimzahlThread(liste1);
        PrimzahlThread thread2 = new PrimzahlThread(liste2);
        PrimzahlThread thread3 = new PrimzahlThread(liste3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<Integer, Boolean> gesamtErgebnis = new HashMap<>();

        gesamtErgebnis.putAll(thread1.getErgebnis());
        gesamtErgebnis.putAll(thread2.getErgebnis());
        gesamtErgebnis.putAll(thread3.getErgebnis());

        for (Map.Entry<Integer, Boolean> eintrag : gesamtErgebnis.entrySet()) {
            System.out.println(eintrag.getKey() + " -> " + eintrag.getValue());
        }
    }
}
