package de.thws.lektion15.ueb1;

import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuizFrage[] fragen = new QuizFrage[4];
        fragen[0] = new QuizMultipleChoice(
                "Was ist 2 + 2?",
                new String[]{"1", "2", "3", "4"},
                3
        );
        fragen[1] = new QuizTextfrage(
                "Wie heißt die Hauptstadt von Frankreich?",
                "Paris"
        );
        fragen[2] = new QuizMultipleChoice(
                "Welche Zahl ist gerade?",
                new String[]{"3", "5", "8", "9"},
                2
        );
        fragen[3] = new QuizTextfrage(
                "Welche Programmiersprache benutzt du gerade?",
                "Java"
        );

        int punkte = 0;

        for (int i = 0; i < fragen.length; i++) {
            System.out.println("Frage " + (i + 1));
            System.out.println(fragen[i].getFrageAntwort());

            if (fragen[i] instanceof QuizMultipleChoice mc) {
                System.out.print("Antwort eingeben (0=A, 1=B, 2=C, 3=D): ");
                int antwort = Integer.parseInt(sc.nextLine());

                if (mc.checkMCantwort(antwort)) {
                    System.out.println("Richtig!");
                    punkte++;
                } else {
                    System.out.println("Falsch!");
                }
            } else if (fragen[i] instanceof QuizTextfrage txt) {
                System.out.print("> ");
                String antwort = sc.nextLine();

                if (txt.checkTxtAntwort(antwort)) {
                    System.out.println("Richtig!");
                    punkte++;
                } else {
                    System.out.println("Falsch!");
                }
            }

            System.out.println();
        }

        System.out.println("Quiz beendet. Du hast " + punkte + " von " + fragen.length + " Punkten erreicht.");
        sc.close();
    }
}