package de.thws.lektion15.ueb1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void profTest(){
        Professor prof = new Professor("1", "2");
        assertEquals("Der Professor 1 das Fach 2", prof.gibTaetigkeitAus());
    }
    @Test
    public void studiTest(){
        Student studi = new Student("3","4");
        assertEquals("Der Student 3 das Fach 4", studi.gibTaetigkeitAus());
    }



}
