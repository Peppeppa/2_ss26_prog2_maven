package de.thws.lektion18.netzwerkGalgenmaennchen;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GalgenServer {

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(5000);
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), false)
        ) {
            System.out.println("Client verbunden.");

            String gesuchtesWort = rndWort();
            char[] strichWort = wortVerdecken(gesuchtesWort).toCharArray();
            int versuche = 0;
            boolean gewonnen = false;

            out.println("Willkommen bei Netzwerk-Galgenmaennchen!");
            out.println("Wort: " + String.valueOf(strichWort));
            out.println("Noch Versuche: " + (15 - versuche));
            out.flush();

            while (versuche < 15 && !gewonnen) {
                String zeile = in.readLine();

                if (zeile == null) {
                    System.out.println("Client hat Verbindung beendet.");
                    break;
                }

                if (zeile.length() == 0) {
                    out.println("Bitte einen Buchstaben eingeben.");
                    out.flush();
                    continue;
                }

                char eingabe = Character.toUpperCase(zeile.charAt(0));

                if (checkCharInWord(gesuchtesWort, eingabe)) {
                    updateStrichWort(gesuchtesWort, strichWort, eingabe);
                    out.println("Treffer!");
                } else {
                    out.println("Leider falsch!");
                }

                versuche++;
                gewonnen = checkWin(gesuchtesWort, strichWort);

                out.println("Wort: " + String.valueOf(strichWort));
                out.println("Noch Versuche: " + (15 - versuche));

                if (gewonnen) {
                    out.println("GEWONNEN! Das Wort war: " + gesuchtesWort);
                } else if (versuche >= 15) {
                    out.println("VERLOREN! Das Wort war: " + gesuchtesWort);
                }

                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public static boolean checkWin(String rndWord, char[] strichWort) {
        String strichAlsString = String.valueOf(strichWort);
        return strichAlsString.equals(rndWord);
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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == userInput) {
                return true;
            }
        }
        return false;
    }

    public static String wortVerdecken(String input) {
        char[] arr = input.toCharArray();
        char[] strich = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                strich[i] = ' ';
            } else {
                strich[i] = '_';
            }
        }
        return String.valueOf(strich);
    }

    public static String rndWort() {
        String[] wort = new String[20];
        wort[0] = "Test";
        wort[1] = "Rott";
        wort[2] = "Zeug";
        wort[3] = "Rindfleischettiketierungsgesetz";
        wort[4] = "Auto";
        wort[5] = "Zug";
        wort[6] = "Schinkennudeln";
        wort[7] = "Pizza";
        wort[8] = "GitHub";
        wort[9] = "Racket";
        wort[10] = "Bruecke";
        wort[11] = "Schornsteinfeger";
        wort[12] = "Paketbote";
        wort[13] = "Test2";
        wort[14] = "Test43";
        wort[15] = "Test5";
        wort[16] = "Test6";
        wort[17] = "Test7";
        wort[18] = "Test8";
        wort[19] = "Test9";

        int index = (int) (Math.random() * 20);
        return wort[index].toUpperCase();
    }
}