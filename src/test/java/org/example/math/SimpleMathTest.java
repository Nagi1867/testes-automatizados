package org.example.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathTest {
    @Test
    void TestSum() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;
        assertEquals(expected, actual, () ->  firstNumber + "+" + secondNumber + " did not produce " + expected);
        assertNotEquals(9.2, actual);
        assertNotNull(actual);
    }
}
