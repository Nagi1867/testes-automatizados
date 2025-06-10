package org.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MethodOrderedRandOnlyTest {
    @Test
    void testA() {
        System.out.println("A");
    }
    @Test
    void testB() {
        System.out.println("B");
    }
    @Test
    void testC() {
        System.out.println("C");
    }
}
