package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;

public class level3 {
    // Textdatei kopieren
    public static void copyTextFile(String sourcePath, String targetPath){
        try(
                BufferedReader br = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath));
                ){
            String line;
            while ((line = br.readLine()) != null){
                try{
                    bw.write(line);
                    bw.newLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    // Datei kopieren und Zeilen in Großbuchstaben schreiben

    public static void copyUpperCase(String sourcePath, String targetPath){
        try(
                BufferedReader br = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath));
                ){
            String line;
            while ((line = br.readLine()) != null){
                try{
                    bw.write(line.toUpperCase());
                    bw.newLine();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // Leere Zeilen entfernen

    public static void removeEmptyLines(String sourcePath, String targetPath){
        try(
                BufferedReader br = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath));
                ){
            String line;
            while((line = br.readLine()) != null){
                if(line.trim()!=null){
                    bw.write(line);
                    bw.newLine();
                }
            }
        }catch(IOException e ){
            e.printStackTrace();
        }
    }


}
