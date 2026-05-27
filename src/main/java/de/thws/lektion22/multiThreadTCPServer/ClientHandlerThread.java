package de.thws.lektion22.multiThreadTCPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class ClientHandlerThread extends Thread {

    private Socket clientSocket;

    public ClientHandlerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Client in Thread: " + Thread.currentThread().getName());
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
        ) {

            System.out.println("Starte Verarbeitung in " + Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Beende Verarbeitung in " + Thread.currentThread().getName());
            String zeile = in.readLine();
            if (zeile == null || zeile.isBlank()) {
                out.println("leere zeile.");
                return;
            }
            ArrayList<Integer> zahlenListe = new ArrayList<>();

            String[] teile = zeile.split(" ");

            for ( String teil : teile){
                int zahl = Integer.parseInt(teil);
                zahlenListe.add(zahl);
            }

            PrimzahlenPruefer pruefer = new PrimzahlenPruefer();
            Map<Integer, Boolean> ergebnis = pruefer.pruefeListe(zahlenListe);

            out.println(ergebnis);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
