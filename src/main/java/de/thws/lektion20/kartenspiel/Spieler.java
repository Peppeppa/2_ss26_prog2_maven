package de.thws.lektion20.kartenspiel;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Spieler {
    private String name;
    private Set<Karte> hand;

    public Spieler(String name){
        this.name = name;
        this.hand = new TreeSet<>();
    }

    public String getName(){
        return this.name;
    }
    public void karteAufnehmen(Karte karte){
        hand.add(karte);
    }
    public Set<Karte> getHand(){
        return hand;
    }
    public void handAusgeben(){
        System.out.println("Hand von " + this.name + " :");

        Iterator<Karte> iterator = hand.iterator();

        while (iterator.hasNext()){
            Karte karte = iterator.next();
            System.out.println("- " + karte);
        }
    }


}
