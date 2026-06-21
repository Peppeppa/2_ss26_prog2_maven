package de.thws.klausurvorbereitung.ioStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class level7 {
    // Prüfungsaufgaben

    public static int countLines(String path) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path)))) {
            int cnt = 0;

            while ((br.readLine()) != null) {
                cnt++;
            }
            return cnt;
        }
    }

    public static boolean containsWord(String path, String word) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    return true;
                }
            }

        }
        return false;
    }


    public static List<String> findLinesContaining(String path, String word) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path),
                                StandardCharsets.UTF_8))) {
            String line;
            List<String> list = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    list.add(line);
                }
            }
            return list;
        }
    }

    public static void filterLines(String sourcePath, String targetPath, String word) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(sourcePath)));
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(targetPath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        }
    }

    public static Map<String, Integer> readAges(String path) throws IOException {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path),
                                StandardCharsets.UTF_8))
        ) {
            Map<String, Integer> imTheMap = new HashMap<>();
            String line;

            while ((line = br.readLine()) != null) {
                String[] teile = line.split(";");

                String name = teile[0];
                int alter = Integer.parseInt(teile[1]);

                imTheMap.put(name, alter);
            }

            return imTheMap;
        }
    }


}
