package de.thws;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PunktTest {

    @Test
    public void testVerschiebePunkt(){
        Punkt test1 = new Punkt();
        test1.verschiebePunkt(1,2);
        assertEquals(1,test1.x);
        assertEquals(2,test1.y);
        try{
            test1.verschiebePunkt(-1,-2);
            fail("RuntimeException erwartet");
        } catch (RuntimeException e){
            String fehler = e.getMessage();
            assertEquals("ungueltig", fehler);
        }
        try{
            test1.verschiebePunkt(1921,5);
            fail("RuntimeException erwartet");
        } catch (RuntimeException e){
            String fehler = e.getMessage();
            assertEquals("ungueltig", fehler);
        }
        try{
            test1.verschiebePunkt(5,1081);
            fail("RuntimeException erwartet");
        } catch (RuntimeException e){
            String fehler = e.getMessage();
            assertEquals("ungueltig", fehler);
        }
    }
}
