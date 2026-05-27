package de.thws.lektion22.multiThreadTCPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class ServerGeschachtelt {
    public static void main(String[] args) {
        final int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server läuft auf Port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client verbunden: " + clientSocket.getInetAddress());

                ClientHandlerThread clientHandlerThread = new ClientHandlerThread(clientSocket);
                clientHandlerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandlerThread extends Thread {

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
                            clientSocket.getOutputStream(), true)
            ) {
                String zeile = in.readLine();

                if (zeile == null || zeile.isBlank()) {
                    out.println("Keine Zahlen empfangen.");
                    return;
                }

                ArrayList<Integer> zahlenListe = new ArrayList<>();

                String[] teile = zeile.trim().split("\\s+");

                for (String teil : teile) {
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
}
