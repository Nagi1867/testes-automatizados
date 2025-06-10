package org.example;

import org.junit.jupiter.api.*;

//@Order(1)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedRandOnlyTest {
    StringBuilder actualValue = new StringBuilder("");

    @AfterEach
    void AfterEach() {
        System.out.println("The actual value is: " + actualValue);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("A");
        actualValue.append("1");
    }
    @Test
    @Order(3)
    void testB() {
        System.out.println("B");
        actualValue.append("2");
    }
    @Test
    @Order(2)
    void testC() {
        System.out.println("C");
        actualValue.append("3");
    }
}
