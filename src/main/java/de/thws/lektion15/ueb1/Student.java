package de.thws.lektion15.ueb1;

public class Student extends Person{
    public Student (String taetigkeit, String fach){
        super(taetigkeit, fach);

    }

    public String gibTaetigkeitAus(){
        return "Der Student " + taetigkeit + " das Fach " + fach;
    }

}
