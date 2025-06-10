package org.example;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class FooBarTest {
    @Test
    void Test() {
        System.out.println("Hello World!");
    }
}
