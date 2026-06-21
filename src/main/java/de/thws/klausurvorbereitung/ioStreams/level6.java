package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class level6 {

    //Fehlerbehandlung bewusst üben

    //Datei sicher lesen mit eigener Fehlermeldung

    public static void safePrintFile(String path){
        try(
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path)))
        ){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException f){
            System.out.println("Datei nicht gefunden");
        } catch (IOException e) {
            System.out.println("Fehler beim lesen der Datei");
        }
    }

    public static String readFirstLine(String path) throws IOException{
       try(BufferedReader br = new BufferedReader(
               new InputStreamReader(
                       new FileInputStream(path),
                       StandardCharsets.UTF_8))){

           return br.readLine();
       }
    }




}
