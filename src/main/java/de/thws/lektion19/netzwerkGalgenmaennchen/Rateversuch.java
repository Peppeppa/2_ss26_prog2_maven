package de.thws.lektion19.netzwerkGalgenmaennchen;

import java.io.Serializable;

public class Rateversuch implements Serializable {
    private final char buchstabe;

    public Rateversuch(char buchstabe) {
        this.buchstabe = Character.toUpperCase(buchstabe);
    }

    public char getBuchstabe() {
        return buchstabe;
    }
}