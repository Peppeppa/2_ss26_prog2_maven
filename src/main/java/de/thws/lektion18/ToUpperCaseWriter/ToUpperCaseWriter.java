package de.thws.lektion18.ToUpperCaseWriter;

import java.io.IOException;
import java.io.Writer;

public class ToUpperCaseWriter implements AutoCloseable {
    Writer os;
    public ToUpperCaseWriter(Writer os) {
        this.os = os;
    }
    public void write(char c) throws IOException {
        os.write(Character.toUpperCase(c));
    }
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++)
            write(cbuf[i]);
    }
    public void write(String str, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++)
            write(str.charAt(i));
    }
    public void flush() throws IOException {
        os.flush();
    }
    public void close() throws IOException {
        os.close();
    }
}
