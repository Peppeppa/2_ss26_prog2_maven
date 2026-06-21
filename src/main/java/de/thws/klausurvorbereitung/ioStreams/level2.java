package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;
import java.util.List;

public class level2 {

    // Datei zeilenweise lese

    public static void printLines(String path) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(path));
        ) {

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Zeilen nummeriert ausgeben
    public static void printLinesWithNumbers(String path){
        try(
                BufferedReader br = new BufferedReader(new FileReader(path));
                ){
            String line;
            int cnt = 1;
            while((line = br.readLine()) != null) {
                System.out.println(cnt + ": " + line);
                cnt++;
            }

            }catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Liste von Strings in Datei schreiben
    public static void writeLines(String path, List<String> lines){
       try(
               BufferedWriter bw = new BufferedWriter(new FileWriter(path))
               ) {
           for (String line : lines){
               bw.write(line);
               bw.newLine();


           }
       }catch(IOException e){
           e.printStackTrace();
       }
    }



}
