package de.thws.lektion18.studiengangsplitter;

import java.io.*;

public class StudiengangSplitter {

    public static void main(String[]args){
        try {
            splitStudiengaenge("MatrNr.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void splitStudiengaenge(String quelle) throws IOException, MatrikelNummerException {


        try (BufferedReader br = new BufferedReader(new FileReader(quelle));
             BufferedWriter winf = new BufferedWriter(new FileWriter("WInfNr.txt"));
             BufferedWriter inf = new BufferedWriter(new FileWriter("InfNr.txt"));
             BufferedWriter ec = new BufferedWriter(new FileWriter("ECNr.txt"))
        ) {
            String line;

            while ((line = br.readLine()) != null) {

                // 1. Länge prüfen
                if (line.length() != 7) {
                    throw new MatrikelNummerException("Ungültige Matrikelnummer: " + line);
                }

                // 2. Nur Ziffern prüfen
                for (int i = 0; i < 7; i++) {
                    char c = line.charAt(i);
                    if (c < '0' || c > '9') {
                        throw new MatrikelNummerException("Ungültige Matrikelnummer: " + line);
                    }
                }

                // 3. Studiengang anhand der ersten zwei Stellen
                char c0 = line.charAt(0);
                char c1 = line.charAt(1);

                if (c0 == '5' && c1 == '0') {
                    // 5000000..5099999 Studiengang WInf
                    winf.write(line);
                    winf.newLine();

                } else if (c0 == '5' && c1 == '1') {
                    // 5100000..5199999 Studiengang Inf
                    inf.write(line);
                    inf.newLine();

                } else if (c0 == '6' && c1 == '1') {
                    // 6100000..6199999 Studiengang EC
                    ec.write(line);
                    ec.newLine();

                } else {
                    throw new MatrikelNummerException("Ungültige Matrikelnummer: " + line);
                }
            }


        }
    }
}
