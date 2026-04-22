package de.thws.lektion18.netzwerkGalgenmaennchen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GalgenClient {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 5000);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), false);
                Scanner sc = new Scanner(System.in)
        ) {
            String serverAntwort;

            // Anfangsausgabe vom Server lesen
            for (int i = 0; i < 3; i++) {
                serverAntwort = in.readLine();
                if (serverAntwort != null) {
                    System.out.println(serverAntwort);
                }
            }

            while (true) {
                System.out.print("Bitte Buchstaben eingeben: ");
                String eingabe = sc.nextLine();

                out.println(eingabe);
                out.flush();

                // Antwortblock vom Server lesen
                String zeile1 = in.readLine();
                String zeile2 = in.readLine();
                String zeile3 = in.readLine();

                if (zeile1 != null) System.out.println(zeile1);
                if (zeile2 != null) System.out.println(zeile2);
                if (zeile3 != null) System.out.println(zeile3);

                if (zeile3 != null &&
                        (zeile3.startsWith("GEWONNEN") || zeile3.startsWith("VERLOREN"))) {
                    break;
                }

                // Falls noch eine Abschlussmeldung kommt
                if (zeile1 != null &&
                        (zeile1.startsWith("GEWONNEN") || zeile1.startsWith("VERLOREN"))) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}