package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class level5 {
// Encoding und Brückenklassen
    //Textdateien in UTF-8 lesen

    public static void printUtf8File(String path){
        try(
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(path),
                                        StandardCharsets.UTF_8));
        ){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeUtf8File(String path, List<String> lines){
        try(
                BufferedWriter bw =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream(path),
                                        StandardCharsets.UTF_8))
                ){

            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
