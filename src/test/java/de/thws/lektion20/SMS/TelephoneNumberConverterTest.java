package de.thws.lektion20.SMS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelephoneNumberConverterTest {

    @Test
    public void testConvertSingleLetters() throws IllegalTelephoneNumberException {
        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        assertEquals("2", converter.convert("A"));
        assertEquals("3", converter.convert("D"));
        assertEquals("9", converter.convert("Z"));
    }

    @Test
    public void testConvertWord() throws IllegalTelephoneNumberException {
        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        assertEquals("32585823839", converter.convert("FAKULTAETFW"));
    }

    @Test
    public void testConvertLowerCaseWord() throws IllegalTelephoneNumberException {
        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        assertEquals("43556", converter.convert("hello"));
    }

    @Test
    public void testInvalidCharacterThrowsException() {
        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        assertThrows(
                IllegalTelephoneNumberException.class,
                () -> converter.convert("HALLO!")
        );
    }

    @Test
    public void testEmptyString() throws IllegalTelephoneNumberException {
        TelephoneNumberConverter converter = new TelephoneNumberConverter();

        assertEquals("", converter.convert(""));
    }
}
