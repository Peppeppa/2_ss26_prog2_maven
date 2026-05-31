package de.thws.lektion21.exam;

import java.io.*;
import java.util.ArrayList;

public class Exam {

    private ArrayList<Question> fragen = new ArrayList<>();


     public static void main(String[] args) throws IOException{
         Exam testung = new Exam();
         testung.readQuestion();
         for (Question q : testung.fragen){
             System.out.println(q.text);
         }
         testung.toTest();

     }

    private static class Question {
        String text; //fragetext

        public Question(String frage){
            this.text = frage;
        }

        public static Question toQuestion(String line) {
            return new Question(line);
            //Wandelt eine eingelesene Zeile in ein Question-Objekt um
        }
    }


     public String readHeaderFromFile() throws IOException{
        String ausgabe = "";
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader("header.tex"));){
            while((ausgabe = br.readLine()) != null){
                if (ausgabe.contains("begin{document}")){
                    result += ausgabe + "\n";
                    return result;
                }else{
                    result += ausgabe + "\n";
                }
            }
        }
        return result;
     }

     public void readQuestion() throws IOException{
         try(BufferedReader br = new BufferedReader(new FileReader("questions.csv"))){
             String current;

             while((current = br.readLine()) != null){
             Question neu = new Question(current);
             fragen.add(neu);
             }
         }
     }

     public void toTest()throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("test.tex"));){
            String headerLine = readHeaderFromFile();
            bw.write(headerLine);

            for (Question q : fragen){
                bw.write("\\textbf{" + q.text + "}\\\\");
                bw.newLine();
            }

            bw.write("\\end{document}");

        }
     }

}
