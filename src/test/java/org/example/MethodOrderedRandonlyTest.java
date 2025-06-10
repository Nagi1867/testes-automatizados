package org.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(1)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedRandOnlyTest {
    @Test
    @Order(1)
    void testA() {
        System.out.println("A");
    }
    @Test
    @Order(3)
    void testB() {
        System.out.println("B");
    }
    @Test
    @Order(2)
    void testC() {
        System.out.println("C");
    }
}
