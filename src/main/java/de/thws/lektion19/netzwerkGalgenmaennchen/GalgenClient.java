package de.thws.lektion19.netzwerkGalgenmaennchen;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class GalgenClient {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 5000);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Scanner sc = new Scanner(System.in)
        ) {
            out.flush();

            ServerAntwort startAntwort = (ServerAntwort) in.readObject();
            System.out.println(startAntwort.getAnzeige());

            while (!startAntwort.isSpielBeendet()) {
                System.out.print("Bitte Buchstaben eingeben: ");
                String eingabe = sc.nextLine();

                if (eingabe.isEmpty()) {
                    System.out.println("Bitte mindestens einen Buchstaben eingeben.");
                    continue;
                }

                Rateversuch rateversuch = new Rateversuch(eingabe.charAt(0));

                out.writeObject(rateversuch);
                out.flush();

                ServerAntwort antwort = (ServerAntwort) in.readObject();

                System.out.println(antwort.getAnzeige());

                if (antwort.isSpielBeendet()) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}