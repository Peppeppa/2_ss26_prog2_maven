package de.thws.klausurvorbereitung.ostap.lektion18.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    static void main() {
        try(
                ServerSocket socket = new ServerSocket(5000);
                Socket client = socket.accept();

                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        client.getInputStream()));
                BufferedWriter bw =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        client.getOutputStream()));){
            String line;
            System.out.println("client accepted");
            while ((line = br.readLine()) != null){
                bw.write("das kam hier an " + line);
                bw.newLine();
                bw.flush();
            }

        }catch (IOException exception){
            exception.printStackTrace();

        }
    }


}
