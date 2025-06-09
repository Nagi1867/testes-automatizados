package org.example.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathTest {
    @Test
    void TestSum() {
        SimpleMath math = new SimpleMath();
        Double actual = math.sum(6.2D, 2D);
        double expected = 8.2D;
        assertEquals(expected, actual, "My message");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);
    }
}
