package de.thws.lektion19.netzwerkGalgenmaennchen;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GalgenServer {

    private static final int MAX_VERSUCHE = 15;

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(5000);
                Socket socket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            out.flush();

            System.out.println("Client verbunden.");

            String gesuchtesWort = rndWort();
            char[] strichWort = wortVerdecken(gesuchtesWort).toCharArray();

            int versuche = 0;
            boolean gewonnen = false;
            boolean beendet = false;

            out.writeObject(new ServerAntwort(
                    "Willkommen bei Netzwerk-Galgenmaennchen!\nWort: "
                            + String.valueOf(strichWort)
                            + "\nNoch Versuche: " + (MAX_VERSUCHE - versuche),
                    false,
                    false,
                    false
            ));
            out.flush();

            while (!beendet) {
                Object obj = in.readObject();

                if (!(obj instanceof Rateversuch)) {
                    continue;
                }

                Rateversuch rateversuch = (Rateversuch) obj;
                char eingabe = rateversuch.getBuchstabe();

                boolean treffer = checkCharInWord(gesuchtesWort, eingabe);

                if (treffer) {
                    updateStrichWort(gesuchtesWort, strichWort, eingabe);
                }

                versuche++;
                gewonnen = checkWin(gesuchtesWort, strichWort);
                beendet = gewonnen || versuche >= MAX_VERSUCHE;

                StringBuilder antwort = new StringBuilder();

                antwort.append(treffer ? "Treffer!" : "Leider falsch!");
                antwort.append("\nWort: ").append(String.valueOf(strichWort));
                antwort.append("\nNoch Versuche: ").append(MAX_VERSUCHE - versuche);

                if (gewonnen) {
                    antwort.append("\nGEWONNEN! Das Wort war: ").append(gesuchtesWort);
                } else if (versuche >= MAX_VERSUCHE) {
                    antwort.append("\nVERLOREN! Das Wort war: ").append(gesuchtesWort);
                }

                out.writeObject(new ServerAntwort(
                        antwort.toString(),
                        gewonnen,
                        beendet,
                        treffer
                ));
                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public static boolean checkWin(String rndWord, char[] strichWort) {
        return String.valueOf(strichWort).equals(rndWord);
    }

    public static char[] updateStrichWort(String rndWord, char[] strichWort, char userInput) {
        char[] arr = rndWord.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == userInput) {
                strichWort[i] = userInput;
            }
        }

        return strichWort;
    }

    public static boolean checkCharInWord(String rndWord, char userInput) {
        char[] arr = rndWord.toCharArray();

        for (char c : arr) {
            if (c == userInput) {
                return true;
            }
        }

        return false;
    }

    public static String wortVerdecken(String input) {
        char[] arr = input.toCharArray();
        char[] strich = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            strich[i] = arr[i] == ' ' ? ' ' : '_';
        }

        return String.valueOf(strich);
    }

    public static String rndWort() {
        String[] wort = {
                "Test",
                "Rott",
                "Zeug",
                "Rindfleischettiketierungsgesetz",
                "Auto",
                "Zug",
                "Schinkennudeln",
                "Pizza",
                "GitHub",
                "Racket",
                "Bruecke",
                "Schornsteinfeger",
                "Paketbote",
                "Test2",
                "Test43",
                "Test5",
                "Test6",
                "Test7",
                "Test8",
                "Test9"
        };

        int index = (int) (Math.random() * wort.length);
        return wort[index].toUpperCase();
    }
}