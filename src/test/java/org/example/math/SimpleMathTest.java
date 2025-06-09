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
    }

    @Test
    void TestSubtraction() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;
        assertEquals(expected, actual, () ->  firstNumber + "-" + secondNumber + " did not produce " + expected);
    }

    @Test
    void TestMultiplication() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4D;
        assertEquals(expected, actual, () ->  firstNumber + "*" + secondNumber + " did not produce " + expected);
    }

    @Test
    void TestDivision() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;
        assertEquals(expected, actual, () ->  firstNumber + "/" + secondNumber + " did not produce " + expected);
    }

    @Test
    void TestMean() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;
        assertEquals(expected, actual, () ->  "(" + firstNumber + "+" + secondNumber + ")/2" + " did not produce " + expected);
    }

    @Test
    void TestSquareRoot() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 81D;
        Double actual = math.squareRoot(firstNumber);
        double expected = 9D;
        assertEquals(expected, actual, () -> "Square Root of " + firstNumber + " did not produce " + expected);;
    }
}
