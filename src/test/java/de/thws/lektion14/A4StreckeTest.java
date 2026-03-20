package de.thws.lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class A4StreckeTest {
    @Test
    public void testMinInA(){
        A4Strecke test = new A4Strecke(1,2);
        assertEquals(1,test.a);
        assertEquals(2,test.b);
        try{
            test = new A4Strecke(0, 2);
            fail("IllegalArgumentException erwartet");
        }catch(IllegalArgumentException e){
            String fehler = e.getMessage();
            assertEquals("nur ganzzahlige positive Zahlen", fehler);
        }
        test = new A4Strecke(2,1);
        assertTrue(test.a < test.b);
    }
    @Test
    public void testUeberschneidung(){
        A4Strecke x;
        A4Strecke y;

        // nur Berührung
        x = new A4Strecke(1, 3);
        y = new A4Strecke(3, 5);
        assertFalse(x.ueberschneidung(y));

        // komplett getrennt
        x = new A4Strecke(1, 2);
        y = new A4Strecke(4, 6);
        assertFalse(x.ueberschneidung(y));

        // teilweise Überschneidung
        x = new A4Strecke(1, 4);
        y = new A4Strecke(3, 6);
        assertTrue(x.ueberschneidung(y));

        // andere Reihenfolge, auch Überschneidung
        x = new A4Strecke(3, 6);
        y = new A4Strecke(1, 4);
        assertTrue(x.ueberschneidung(y));

        // eine Strecke liegt komplett in der anderen
        x = new A4Strecke(1, 10);
        y = new A4Strecke(4, 6);
        assertTrue(x.ueberschneidung(y));

        // identische Strecken
        x = new A4Strecke(2, 5);
        y = new A4Strecke(2, 5);
        assertTrue(x.ueberschneidung(y));
    }
    @Test
    public void testToString() {
        A4Strecke test;

        test = new A4Strecke(4, 4);
        assertEquals("4", test.toString());

        test = new A4Strecke(3, 5);
        assertEquals("3--5", test.toString());

        test = new A4Strecke(2, 8);
        assertEquals("2------8", test.toString());

        test = new A4Strecke(5, 3);
        assertEquals("3--5", test.toString());
    }
}
