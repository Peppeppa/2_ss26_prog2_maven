package de.thws.lektion15.ueb1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AngestellterTest {
    final double DELTA = 0.00001;


    public void createPeter(){
        Angestellter angestellter = new Angestellter("abc", "Peter", "1", 1000.0, "01.01.2000");
    }
    public void createKlaus(){
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter("def", "Klaus", "2", 1000.0, "20.2.3000");
    }
    @Test
    public void erstelleAngestelltenTest(){
        Angestellter angestellter = new Angestellter("abc", "Peter", "1", 1000.0, "01.01.2000");
        assertEquals("abc", angestellter.nachname);
        assertEquals("Peter", angestellter.vorname);
        assertEquals("1", angestellter.identifikator);
        assertEquals(1000.0, angestellter.grundgehalt);
        assertEquals("01.01.2000", angestellter.geburtsdatum);
        assertEquals(1000.0, angestellter.gehalt, DELTA);
    }
    @Test
    public void berechneGehalttest(){
        Angestellter angestellter = new Angestellter("abc", "Peter", "1", 1000.0, "01.01.2000");
        angestellter.grundgehalt = 2000.0;
        angestellter.berechneGehalt();
        assertEquals(2000.0, angestellter.gehalt, DELTA);
    }
    @Test
    public void erstelleAbteilungsleiterTest(){
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter("def", "Klaus", "2", 1000.0, "20.2.3000");
        assertEquals(2000.0, abteilungsleiter.gehalt, DELTA);
    }
    @Test
    public void befoerdernTest(){
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter("def", "Klaus", "2", 1000.0, "20.2.3000");
        Angestellter angestellter = new Angestellter("abc", "Peter", "1", 1000.0, "01.01.2000");
        abteilungsleiter.befoerdern(angestellter);
        assertEquals(1100, angestellter.gehalt);
    }


}
