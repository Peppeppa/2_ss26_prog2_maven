package de.thws.lektion18.ToUpperCaseWriter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToUpperCaseWriterTest {

    private String testChar(char c) {
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(baos);
                ToUpperCaseWriter writer = new ToUpperCaseWriter(osw)
        ) {
            writer.write(c);
            writer.flush();
            return baos.toString();
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
            return null;
        }
    }

    @Test
    public void writeCharTest() {
        assertEquals("A", testChar('a'));
    }

    @Test
    public void writeCharNonTest() {
        assertEquals("1", testChar('1'));
    }

    @Test
    public void testAsciiLetters() {
        for (int i = 0; i < 128; i++) {
            char c = (char) i;
            if (c >= 'a' && c <= 'z') {
                assertEquals(String.valueOf(Character.toUpperCase(c)), testChar(c));
            }
        }
    }

    @Test
    public void testAsciiNonLetters() {
        for (int i = 0; i < 128; i++) {
            char c = (char) i;
            if (c < 'a' || c > 'z') {
                assertEquals(String.valueOf(c), testChar(c));
            }
        }
    }
}