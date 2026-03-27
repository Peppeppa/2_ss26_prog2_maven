package de.thws.lektion15.ueb1;

public class Professor extends Person{
    public Professor (String taetigkeit, String fach){
        super(taetigkeit, fach);

    }

    public String gibTaetigkeitAus(){
        return "Der Professor " + taetigkeit + " das Fach " + fach;
    }
}
