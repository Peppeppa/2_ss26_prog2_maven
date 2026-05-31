package de.thws.lektion22.multiThreadTCPServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MTTCPServer {

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
}
