package de.thws.lektion17.bytestreams;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class StreamVerdopplung extends OutputStream{

    private OutputStream out1;
    private OutputStream out2;

    public StreamVerdopplung(OutputStream out1, OutputStream out2) {
        this.out1 = out1;
        this.out2 = out2;
    }

    @Override
    public void write(int b) throws IOException {
        try {
            out1.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out2.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void close() throws IOException {
        boolean fehlerOut1 = false;
        boolean fehlerOut2 = false;

        try {
            out1.close();
        } catch (IOException e) {
            fehlerOut1 = true;
        }

        try {
            out2.close();
        } catch (IOException e) {
            fehlerOut2 = true;
        }

        if (fehlerOut1 && fehlerOut2) {
            throw new IOException("Fehler beim Schließen von out1 und out2.");
        } else if (fehlerOut1) {
            throw new IOException("Fehler beim Schließen von out1.");
        } else if (fehlerOut2) {
            throw new IOException("Fehler beim Schließen von out2.");
        }
    }
    public static void main(String[] args) {
        try {
            FileOutputStream fos1 = new FileOutputStream("file1.txt");
            FileOutputStream fos2 = new FileOutputStream("file2.txt");

            StreamVerdopplung doubler = new StreamVerdopplung(fos1, fos2);

            doubler.write(65);
            doubler.write(66);
            doubler.write(67);

            doubler.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
