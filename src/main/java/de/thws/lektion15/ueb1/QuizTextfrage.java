package de.thws.lektion15.ueb1;

public class QuizTextfrage extends QuizFrage{
    private String antwort;

    public QuizTextfrage(String frage, String antwort){
        super(frage);
        this.antwort = antwort;
    }

    public boolean checkTxtAntwort(String antwort) {
        return this.antwort.equalsIgnoreCase(antwort.trim());
    }

    @Override
    public String getFrageAntwort() {
        return "Fragentext:" + System.lineSeparator()
                + frage + System.lineSeparator()
                + "Antwort eingeben:";
    }
}
