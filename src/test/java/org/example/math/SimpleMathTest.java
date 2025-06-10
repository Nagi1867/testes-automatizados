package org.example.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {
    SimpleMath math = new SimpleMath();

    @BeforeAll
    static void setup() {
        System.out.println("Running BeforeAll method");
    }
    @AfterAll
    static void cleanup() {
        System.out.println("Running AfterAll method");
    }
    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Running BeforeEach method");
    }
    @AfterEach
    void afterEachMethod() {
        System.out.println("Running AfterEach method");
    }
    //test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void TestSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        //AAA Arrange,Act, Assert
        //Given
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expected = 8.2D;
        //When
        Double actual = math.sum(firstNumber, secondNumber);
        //Then
        assertEquals(expected, actual, () ->  firstNumber + "+" + secondNumber + " did not produce " + expected);
    }

    @Test
    @DisplayName("Subtraction 6.2 - 2 = 4.2")
    void TestSubtraction() {
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;
        assertEquals(expected, actual, () ->  firstNumber + "-" + secondNumber + " did not produce " + expected);
    }

    @Test
    void TestMultiplication() {
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4D;
        assertEquals(expected, actual, () ->  firstNumber + "*" + secondNumber + " did not produce " + expected);
    }

    @Test
    void TestDivision() {
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;
        assertEquals(expected, actual, () ->  firstNumber + "/" + secondNumber + " did not produce " + expected);
    }

    //@Disabled("teste")
    @Test
    @DisplayName("Test Division by Zero")
    void TestDivision_When_FirstNumberIsDividedByZero_ShouldReturnEightDotThrowArithmeticException() {
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "Impossible to divide by zero!";

        //when & then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
            //when & then
            math.division(firstNumber, secondNumber);
        }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message");
    }

    @Test
    void TestMean() {
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;
        assertEquals(expected, actual, () ->  "(" + firstNumber + "+" + secondNumber + ")/2" + " did not produce " + expected);
    }

    @Test
    void TestSquareRoot() {
        double firstNumber = 81D;
        Double actual = math.squareRoot(firstNumber);
        double expected = 9D;
        assertEquals(expected, actual, () -> "Square Root of " + firstNumber + " did not produce " + expected);;
    }
}
