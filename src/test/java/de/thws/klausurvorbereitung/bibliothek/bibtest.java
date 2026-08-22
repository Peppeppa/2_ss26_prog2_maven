package de.thws.klausurvorbereitung.bibliothek;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class bibtest {

    private Bibliothek bib1;

    private GebBuch a;
    private GebBuch b;
    private GebBuch b2;
    private Hoerbuch c;
    private Hoerbuch d;


    @BeforeEach
    public void prep(){
        a = new GebBuch("name1", "autor1", "verlag1", 1111, 111, "reiheA");
        b = new GebBuch("name2", "autor2", "verlag2", 2222, 222, "reiheA");
        b2 = new GebBuch("aaa", "autor2", "verlag2", 2222, 222, "reiheA");
        c = new Hoerbuch("name3", "autor3", "verlag3", 3333, 333, "reiheB");
        d = new Hoerbuch("name4", "autor4", "verlag4", 4444, 444, "reiheB");

        bib1 = new Bibliothek();

        bib1.add(a);
        bib1.add(b);
        bib1.add(b2);
        bib1.add(c);
        bib1.add(d);
    }
    @Test
    public void testSortiereNachAutorUndDannNachName() {
        List<Buch> sortiert = bib1.sortiere();

        assertEquals(a, sortiert.get(0));   // autor1, name1
        assertEquals(b2, sortiert.get(1));  // autor2, aaa
        assertEquals(b, sortiert.get(2));   // autor2, name2
        assertEquals(c, sortiert.get(3));   // autor3, name3
        assertEquals(d, sortiert.get(4));   // autor4, name4
    }
}
