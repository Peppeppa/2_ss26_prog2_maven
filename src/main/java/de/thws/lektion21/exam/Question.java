package de.thws.lektion21.exam;

public class Question {
    String text; //fragetext

    public Question(String frage){
        this.text = frage;
    }

    public static Question toQuestion(String line) {
    Question neu = new Question(line);
    return neu;
    }
}




