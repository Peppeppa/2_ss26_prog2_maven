//package de.thws.klausurvorbereitung.ostap.lektion18.tcp;
//
//import java.io.*;
//import java.net.Socket;
//
//public class client {
//
//    static void main() {
//
//
//        try(
//                Socket sock = new Socket("localhost", 5000);
//
//                BufferedReader user = new BufferedReader (new InputStreamReader ( System . in ) );
//                BufferedReader br =
//                        new BufferedReader(
//                                new InputStreamReader(sock.getInputStream()));
//                BufferedWriter bw =
//                        new BufferedWriter(
//                                new OutputStreamWriter(sock.getOutputStream()));){
//
//            while ((in = user.readLine()) !=null){
//                bw.write(in);
//                bw.newLine();
//                bw.flush();
//                String response = br.readLine();
//                System.out.println(response);
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
//}
