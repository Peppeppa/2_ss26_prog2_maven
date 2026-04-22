package de.thws.lektion18.netzwerkGalgenmaennchen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args){
        final int PORT = 5000;
        final String HOST = "localhost";
        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner sc = new Scanner(System.in)
        ) {
            while (true) {
                System.out.print("Eingabe: ");
                String text = sc.nextLine();
                out.println(text);

                String antwort = in.readLine();
                System.out.println("Server: " + antwort);
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
        }
    }

