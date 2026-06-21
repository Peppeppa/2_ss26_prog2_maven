package de.thws.lektion15.getraenkevorraete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetraenkeTest {

    private static final double EPSILON = 0.000001;

    private Bier b1;
    private Bier b2;
    private Wein rw;
    private Wein ww;
    private Getraenk[] ga;

    @BeforeEach
    void createSaufArray() {
        b1 = new Bier("Helles", "Eichhofen", 5.0, 500, 8);
        b2 = new Bier("Alkoholfrei", "Alk", 0.2, 500, 8);
        rw = new Wein("Randersacker", "Rotwein", 8.2, 2040, 1000, 0);
        ww = new Wein("Randersacker", "Weißwein", 18.2, 3000, 750, 0);

        ga = new Getraenk[] { b1, b2, rw, ww };
    }

    @Test
    void getraenkConstructorShouldSetAttributes() {
        Getraenk getraenk = new Getraenk("Eichhofen", "Helles", 5.0, 500, 8);

        assertEquals("Eichhofen", getraenk.herkunft);
        assertEquals("Helles", getraenk.sorte);
        assertEquals(5.0, getraenk.alkoholgehalt, EPSILON);
        assertEquals("nein", getraenk.alkoholfrei);
        assertEquals(500, getraenk.flaschengroesse);
        assertEquals(8, getraenk.flaschenpfand);
    }

    @Test
    void bierConstructorShouldSetAttributes() {
        assertEquals("Eichhofen", b1.herkunft);
        assertEquals("Helles", b1.sorte);
        assertEquals(5.0, b1.alkoholgehalt, EPSILON);
        assertEquals("nein", b1.alkoholfrei);
        assertEquals(500, b1.flaschengroesse);
        assertEquals(8, b1.flaschenpfand);
    }

    @Test
    void weinConstructorShouldSetAttributesIncludingJahrgang() {
        assertEquals("Randersacker", rw.herkunft);
        assertEquals("Rotwein", rw.sorte);
        assertEquals(8.2, rw.alkoholgehalt, EPSILON);
        assertEquals(2040, rw.jahrgang);
        assertEquals("nein", rw.alkoholfrei);
        assertEquals(1000, rw.flaschengroesse);
        assertEquals(0, rw.flaschenpfand);
    }

    @Test
    void alkoholfreiShouldBeJaIfAlcoholIsLessThanZeroPointFive() {
        assertEquals("ja", b2.alkoholfrei);
    }

    @Test
    void alkoholfreiShouldBeNeinIfAlcoholIsExactlyZeroPointFive() {
        Getraenk getraenk = new Getraenk("Test", "Grenzwert", 0.5, 123, 321);

        assertEquals("nein", getraenk.alkoholfrei);
    }

    @Test
    void alkoholfreiShouldBeNeinIfAlcoholIsGreaterThanZeroPointFive() {
        assertEquals("nein", b1.alkoholfrei);
    }

    @Test
    void bierToStringShouldReturnExpectedOutput() {
        String expected = "Herkunft: Eichhofen"
                + "\nSorte: Helles"
                + "\n Alkoholgehalt: 5.0"
                + "\n alkoholfrei: nein";

        assertEquals(expected, b1.toString());
    }

    @Test
    void weinToStringShouldReturnExpectedOutput() {
        String expected = "Herkunft: Randersacker"
                + "\nSorte: Rotwein"
                + "\n Alkoholgehalt: 8.2"
                + "\n Jahrgang: 2040"
                + "\n alkoholfrei: nein";

        assertEquals(expected, rw.toString());
    }

    @Test
    void arrayShouldContainAllDrinks() {
        assertEquals(4, ga.length);

        assertTrue(ga[0] instanceof Bier);
        assertTrue(ga[1] instanceof Bier);
        assertTrue(ga[2] instanceof Wein);
        assertTrue(ga[3] instanceof Wein);
    }
}