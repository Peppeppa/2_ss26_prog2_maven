package de.thws.klausurvorbereitung.altklausur.Aufgabe3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Modul implements Transform<String[], Student>{
    String name;
    List<Student> listeVonStudenten;

    public Modul(String name, String dateipfad){
        this.name = name;
        this.csvImport(dateipfad);
    }

    private void csvImport(String dateipfad){

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(dateipfad)))){

            String line = "";
            int cnt = 0;
            while ((line = in.readLine()) != null){
                if (cnt > 0){
                    String[] result = line.split(";");
                    Student student = transform(result);
                    listeVonStudenten.add(student);
                }
                cnt++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
   public Student transform(String[] input){
        int matnr = Integer.parseInt(input[0]);
        return new Student(input[0], input[1], matnr);
   }
}
