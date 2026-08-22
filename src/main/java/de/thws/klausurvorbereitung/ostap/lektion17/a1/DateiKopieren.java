package de.thws.klausurvorbereitung.ostap.lektion17.a1;

import java.io.*;

public class DateiKopieren {
    static void main() {
        try (InputStream is = new FileInputStream("quelle.txt");
             OutputStream os = new FileOutputStream("ziel.txt")) {
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }

        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
