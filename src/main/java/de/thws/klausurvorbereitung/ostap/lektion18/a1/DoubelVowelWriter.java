package de.thws.klausurvorbereitung.ostap.lektion18.a1;

import java.io.IOException;
import java.io.Writer;

public class DoubelVowelWriter extends Writer {

    private Writer writer;


    @Override
    public void close() throws IOException {

    }

    @Override
    public void write(char[] chars, int i, int i1) throws IOException {

        writer.write(i);

        if("aeiouAEIOU".indexOf((char) i) != -1){
            writer.write(i);
        }

    }

    @Override
    public void flush() throws IOException {

    }
}
