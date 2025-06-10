package org.example.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {
    SimpleMath math = new SimpleMath();

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

    @DisplayName("Test 6.2 / 2 = 3.1")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    @MethodSource
    void TestDivision(double firstNumber, double secondNumber, double expected) {
        Double actual = math.division(firstNumber, secondNumber);
        assertEquals(expected, actual, 2D,() ->  firstNumber + "/" + secondNumber + " did not produce " + expected);
    }

    //public static Stream<Arguments> testDivisionInputParameters() {
    public static Stream<Arguments> TestDivision() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }
}
