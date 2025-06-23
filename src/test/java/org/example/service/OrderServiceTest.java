package org.example.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService service = new OrderService();
    Object defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

    @Test
    void testShouldIncludeRandomOrderId_When_NoOrder() {
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            Order result = service.createOrder("MacBook", 2L, null);

            assertEquals(defaultUuid.toString(), result.getId());
        }
    }
}