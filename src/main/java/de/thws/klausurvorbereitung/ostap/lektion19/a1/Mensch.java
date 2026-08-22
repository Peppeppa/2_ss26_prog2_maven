package de.thws.klausurvorbereitung.ostap.lektion19.a1;

import java.io.Serializable;

public class Mensch extends Lebewesen implements Serializable {
    String beruf;

    public Mensch(String name, String beruf){
        super(name);
        this.beruf = beruf;
    }
    public void beschreibe(){

    }
}
