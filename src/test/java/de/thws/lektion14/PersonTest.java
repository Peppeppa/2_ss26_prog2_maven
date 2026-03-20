package de.thws.lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testCreatePerson() {
        Person test1 = new Person("Stephen", "Eyring", "Abc", "12", 345, "Ort");
        assertEquals("Stephen", test1.vorname);
        assertEquals("Eyring", test1.nachname);
        assertEquals("Abc", test1.adresse.strasse);
        assertEquals("12", test1.adresse.hausnummer);
        assertEquals(345, test1.adresse.postleitzahl);
        assertEquals("Ort", test1.adresse.ort);

        try {
            test1 = new Person("stephen", "Eyring", "Abc", "12", 345, "Ort");
            fail("IllegalArgumentException erwartet");
        } catch(IllegalArgumentException e){
            String fehler = e.getMessage();
            assertEquals("Vorname muss großgeschrieben sein", fehler);
        }

        try {
            test1 = new Person("Stephen", "Eyring", "abc", "12", 345, "Ort");
            fail("IllegalArgumentException erwartet");
        } catch(IllegalArgumentException e){
            String fehler = e.getMessage();
            assertEquals("Strasse muss mit Großbuchstaben beginnen", fehler);
        }

        try {
            test1 = new Person("Stephen", "Eyring", "Abc", "12", 345, "ort");
            fail("IllegalArgumentException erwartet");
        } catch(IllegalArgumentException e){
            String fehler = e.getMessage();
            assertEquals("Ort muss mit Großbuchstaben beginnen", fehler);
        }

        try {
            test1 = new Person("Stephen", "Eyring", "Abc", "a12", 345, "Ort");
            fail("IllegalArgumentException erwartet");
        } catch(IllegalArgumentException e){
            String fehler = e.getMessage();
            assertEquals("Hausnummer muss mit einer Ziffer beginnen", fehler);
        }
    }
}

