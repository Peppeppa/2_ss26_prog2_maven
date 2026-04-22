package de.thws.lektion18.netzwerkGalgenmaennchen;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        final int PORT = 5000;
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String zeile;

            while ((zeile = in.readLine()) != null) {
                System.out.println("Empfangen: " + zeile);
                out.println("OK");
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
