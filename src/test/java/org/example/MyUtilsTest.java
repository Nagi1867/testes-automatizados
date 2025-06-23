package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class MyUtilsTest {
    @Test
    void shoudMockStaticMethodWithParams() {
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
            mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Gabriel"), anyBoolean())).thenReturn("Salve");

            String result = MyUtils.getWelcomeMessage("Gabriel", false);

            assertEquals("Salve", result);
        }
    }
}