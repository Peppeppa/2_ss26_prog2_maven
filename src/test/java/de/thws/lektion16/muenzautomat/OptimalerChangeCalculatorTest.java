package de.thws.lektion16.muenzautomat;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class OptimalerChangeCalculatorTest
{
    private final ChangeCalculator calculator = new OptimalerChangeCalculator();

    @Test
    public void testZeroAmount()
    {
        assertArrayEquals(
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                calculator.getChange(0, 0)
        );
    }

    @Test
    public void testThreeCent()
    {
        // 3 Cent = 1x2 Cent + 1x1 Cent
        assertArrayEquals(
                new int[] {1, 1, 0, 0, 0, 0, 0, 0},
                calculator.getChange(0, 3)
        );
    }

    @Test
    public void testEightCent()
    {
        // 8 Cent = 1x5 Cent + 1x2 Cent + 1x1 Cent
        assertArrayEquals(
                new int[] {1, 1, 1, 0, 0, 0, 0, 0},
                calculator.getChange(0, 8)
        );
    }

    @Test
    public void testFortyCent()
    {
        // 40 Cent = 2x20 Cent
        assertArrayEquals(
                new int[] {0, 0, 0, 0, 2, 0, 0, 0},
                calculator.getChange(0, 40)
        );
    }

    @Test
    public void testNinetyNineCent()
    {
        // 99 Cent = 1x50 + 2x20 + 1x5 + 2x2
        assertArrayEquals(
                new int[] {0, 2, 1, 0, 2, 1, 0, 0},
                calculator.getChange(0, 99)
        );
    }

    @Test
    public void testTwoEuroThirtySeven()
    {
        // 2,37 € = 1x2€ + 1x20c + 1x10c + 1x5c + 1x2c
        assertArrayEquals(
                new int[] {0, 1, 1, 1, 1, 0, 0, 1},
                calculator.getChange(2, 37)
        );
    }

    @Test
    public void testThreeEuroEightyEight()
    {
        // 3,88 € = 1x2€ + 1x1€ + 1x50c + 1x20c + 1x10c + 1x5c + 1x2c + 1x1c
        assertArrayEquals(
                new int[] {1, 1, 1, 1, 1, 1, 1, 1},
                calculator.getChange(3, 88)
        );
    }
}
