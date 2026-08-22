package de.thws.klausurvorbereitung.ostap.lektion19.a1;

import java.io.Serializable;

public class Tier extends Lebewesen implements Serializable {
    String art;

    public Tier (String name, String art){
        super(name);
        this.art = art;

    }

    public void beschreibe(){

    }
}
