package org.example.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private final OrderService service = new OrderService();
    private final Object defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

    @Test
    void testShouldIncludeRandomOrderId_When_NoOrder() {
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            Order result = service.createOrder("MacBook", 2L, null);

            assertEquals(defaultUuid.toString(), result.getId());
        }
    }

    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder() {
        try(MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            Order result = service.createOrder("MacBook", 2L, null);

            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}