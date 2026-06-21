package de.thws.lektion14.mitternachtsformel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class QuadraticFunctionTest {

    private static final double EPSILON = 0.000001;


    @Test
    void testConstructorSuccess(){
        QuadraticFunction test = new QuadraticFunction(-1, 3, -2);
        double[] roots = test.roots();

        assertArrayEquals(new double[] {1.0,2.0}, roots, EPSILON);
    }
    @Test
    void testConstructorA0Exception(){
        assertThrows(IllegalArgumentException.class, () ->{
            new QuadraticFunction(0,1,1);
        });
    }
    @Test
    void testRootsReturnTwoSolutions(){
        QuadraticFunction test = new QuadraticFunction(-1, 3, -2);
        double[] roots = test.roots();
        assertArrayEquals(new double[] {1.0,2.0}, roots,EPSILON);
    }
    @Test
    void rootsShouldReturnOneSolution() {
        QuadraticFunction test = new QuadraticFunction(1, -2, 1);

        double[] roots = test.roots();

        assertArrayEquals(new double[] { 1.0 }, roots, EPSILON);
    }
    @Test
    void testRootsReturnNoRealSolution(){
        QuadraticFunction test = new QuadraticFunction(1, 0, 1);
        double[] roots = test.roots();
        assertEquals(0, roots.length);
    }
}
