package org.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderedRandOnlyTest {
    @Test
    void testA() {
        System.out.println("A");
    }
    @Test
    void testB() {
        System.out.println("B");
    }
}
