package de.thws.lektion15.ueb1;

public class QuizMultipleChoice extends QuizFrage{
    private String[] antworten;
    private int pointerRichtigeAntwort;
    private String[] labels;

    public QuizMultipleChoice(String frage, String[] antworten, int richtig){
        super(frage);

        if (antworten.length != 4) {
            throw new IllegalArgumentException("Es müssen genau 4 Antworten vorhanden sein.");
        }

        this.antworten = antworten;
        this.pointerRichtigeAntwort = richtig;
        labels = new String[]{"A: ","B: ","C: ","D: "};
    }

    public boolean checkMCantwort(int antwort){
        return antwort==pointerRichtigeAntwort;
    }

    @Override
    public String getFrageAntwort() {
        String result = "Fragentext:" + System.lineSeparator();
        result += frage + System.lineSeparator();

        for (int i = 0; i < antworten.length; i++) {
            result += labels[i] + antworten[i] + System.lineSeparator();
        }

        return result;
    }

}
