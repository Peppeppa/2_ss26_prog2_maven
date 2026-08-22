package de.thws.klausurvorbereitung.ostap.lektion17.a2;

import java.io.*;

public class DateiKopierenBuffer {
    static void main() {
//scanner init
        //string dateiname = scannerinegabe....
        try (
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream("quelle.txt")));
                BufferedWriter bw =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("ziel.txt")))){

            String line;
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }

        }catch(IOException e){
        e.printStackTrace();
        }
        File f1 = new File("quelle.txt");
        File f2 = new File("ziel.txt");
        double l1 = f1.length();
        double l2 = f2.length();


//        try(InputStream is = new FileInputStream("quelle.txt");
//            OutputStream os = new FileOutputStream("ziel.txt")){
//            byte[] buffer = new byte[1024];
//            int n;
//            while((n = is.read(buffer)) != -1){
//
//                os.write(buffer, 0, n);
//            }
//        }catch (FileNotFoundException fileNotFoundException){
//            fileNotFoundException.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

    }
}
