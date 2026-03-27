package de.thws.lektion15.ueb1;

public abstract class Person {
    String taetigkeit;
    String fach;

    public Person(String taetigkeit, String fach){
        this.taetigkeit=taetigkeit;
        this.fach=fach;
    }

    public abstract String gibTaetigkeitAus();
}
