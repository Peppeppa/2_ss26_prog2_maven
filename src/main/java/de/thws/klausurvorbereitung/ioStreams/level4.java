package de.thws.klausurvorbereitung.ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class level4 {
    // bytestreams

    //Binärdatei kopieren
    public static void copyBinaryFile(String sourcePath,  String targetPath){
        try(
                FileInputStream fi = new FileInputStream(sourcePath);
                FileOutputStream of = new FileOutputStream(targetPath);
                ){
            byte[] buffer = new byte[1024];
            int laenge;
            while((laenge = fi.read(buffer)) != -1){
                of.write(buffer, 0, laenge);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Datei-Bytes zählen

    public static long countBytes(String path){
        long cnt = 0;
        try(
                FileInputStream fi = new FileInputStream(path);
                ){
            byte[] buffer = new byte[1024];
            long laenge;

            while((laenge = fi.read(buffer)) != -1){
               cnt+=laenge;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return cnt;
    }


}
