package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CheckoutServiceTest {
    @Test
    void testMockObjectConstruction() {
        try(MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class, (mock, context) -> {
            when(mock.chargeCustomer(
                    anyString(),
                    any(BigDecimal.class)
            )).thenReturn(BigDecimal.TEN);
        })) {
            CheckoutService service = new CheckoutService();

            BigDecimal result = service.purchaseProduct("MacBook", "42");

            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }
    }
}