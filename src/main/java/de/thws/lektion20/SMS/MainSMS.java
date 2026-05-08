package de.thws.lektion20.SMS;

import java.io.*;

public class MainSMS {

    public static void main(String[] args) {

        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        String inputFile = "Zeichenkontakte.txt";
        String outputFile = "Nummernkontakte.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String zeile;

            while ((zeile = reader.readLine()) != null) {
                try {
                    String telefonnummer = converter.convert(zeile);

                    writer.write(zeile + " -> " + telefonnummer);
                    writer.newLine();

                } catch (IllegalTelephoneNumberException e) {
                    System.out.println("Zeile wird übersprungen: " + zeile);
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Datei wurde erfolgreich verarbeitet.");

        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben der Datei.");
            System.out.println(e.getMessage());
        }
    }
}
