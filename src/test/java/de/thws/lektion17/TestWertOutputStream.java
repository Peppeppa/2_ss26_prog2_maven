package de.thws.lektion17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class TestWertOutputStream {
    @Test
    public void test_write_gutfall_success() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] data = {10, 20, 30, 40};
        out.write(data, 1, 2);

        byte[] result = out.toByteArray();

        assertTrue(result[0] == 20);
        assertTrue(result[1] == 30);
    }
    @Test
    public void test_write_offsetWrong_exception() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] data = {1, 2, 3};

        boolean error = false;

        try {
            out.write(data, -1, 1);
        } catch (Exception e) {
            error = true;
        }

        assertTrue(error);
    }
    @Test
    public void test_write_tooLong_exception() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] data = {1, 2, 3};

        boolean error = false;

        try {
            out.write(data, 2, 5);
        } catch (Exception e) {
            error = true;
        }

        assertTrue(error);
    }
    @Test
    public void test_write_nullArray_exception() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        boolean error = false;

        try {
            out.write(null, 0, 1);
        } catch (Exception e) {
            error = true;
        }

        assertTrue(error);
    }
}
