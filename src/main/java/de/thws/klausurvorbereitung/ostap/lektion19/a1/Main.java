package de.thws.klausurvorbereitung.ostap.lektion19.a1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Lebewesen> liste = new ArrayList<>();

        liste.add(new Mensch("name", "tester"));
        liste.add(new Mensch("klaus", "dkslfna"));
        liste.add(new Mensch("dfsan", "ndfkjlöa"));
        liste.add(new Tier("asd", "fjf"));
        liste.add(new Tier("nnn", "nmds"));

        // Schreiben
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("output.ser"))) {

            oos.writeObject(liste);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lesen
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("output.ser"))) {

            List<Lebewesen> geleseneListe =
                    (List<Lebewesen>) ois.readObject();

            for (Lebewesen l : geleseneListe) {
                l.beschreibe();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}