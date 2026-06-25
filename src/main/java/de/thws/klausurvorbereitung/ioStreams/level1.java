package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;

public class level1 {

    // Datei zeićhenweise einlesen

    public static void printFile(String path) {

        FileReader reader = null;
        try {
            reader = new FileReader(path);
            int zeichen;
            while ((zeichen = reader.read()) != -1) {
                System.out.println((char) zeichen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void writeText(String path, String text) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void appendText(String path, String text){
        FileWriter writer = null;
        try{
            writer = new FileWriter(path, true); // true = append mode
            writer.write(text);
            writer.write(System.lineSeparator());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if (writer != null) {
                    writer.close();
                }
            }catch(IOException e ){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Hallo Welt");
    }


}

