package de.thws.lektion24.lambdakarte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kartendeck {
    List<Karte> karten;


    public void erzeugeDeck(){
        List<Karte> deck = Stream.of(Farbe.values())
                .flatMap(f -> Stream.of(Wert.values()).map(w -> new Karte(f,w)))
                .collect(Collectors.toList());

    }
}
