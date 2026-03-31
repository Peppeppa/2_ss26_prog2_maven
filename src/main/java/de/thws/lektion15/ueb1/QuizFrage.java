package de.thws.lektion15.ueb1;

public abstract class QuizFrage {
    protected String frage;

    public QuizFrage(String frage){
        this.frage = frage;
    }
    public String getFrage(){
        return frage;
    }

    public abstract String getFrageAntwort();

}
