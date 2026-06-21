package de.thws.klausurvorbereitung.visitor4;

import java.util.List;

public class Main {
    static void main() {
        Regal hauptregal = new Regal("hauptregal");

        Buch cleancode = new Buch("Clean Code", 464);
        Zeitschrift javamag = new Zeitschrift("Java Magazin", 80);

        Regal programmieren = new Regal("regal Programmieren");
        Buch effectjava = new Buch("effective Java", 416);
        Zeitschrift infospec = new Zeitschrift("Informatik Spektrum", 60);

        Regal algorit = new Regal("regal Algorithmen");
        Buch algorithmen = new Buch("Algorithmen", 300);
        Buch datenstruk = new Buch ("Datenstrukturen", 250);


        programmieren.add(effectjava);
        programmieren.add(infospec);
        algorit.add(algorithmen);
        algorit.add(datenstruk);
        hauptregal.add(cleancode);
        hauptregal.add(javamag);
        hauptregal.add(programmieren);
        hauptregal.add(algorit);

        CountVisitor visitor = new CountVisitor();
        hauptregal.accept(visitor);

        System.out.println("buchseitenanzahl: " + visitor.getCount());
    }
}
