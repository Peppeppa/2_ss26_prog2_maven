package de.thws.lektion22.multiThreadTCPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MTTCPClient {


    public static void main(String[] args) {
        final String host = "localhost";
        final int port = 5000;

        try (
                Socket socket = new Socket(host, port);

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))
        ) {
            String zahlen = "17 18 19 20 23 97 100 341";

            System.out.println("Client sendet: " + zahlen);
            out.println(zahlen);

            String antwort = in.readLine();

            System.out.println("Antwort vom Server:");
            System.out.println(antwort);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
