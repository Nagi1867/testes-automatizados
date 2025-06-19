package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {
    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        assertEquals(10, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentsMatcher_ShouldReturn() {
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Erudio");

        assertEquals("Erudio", list.get(anyInt()));
        assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar"));

        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should have throw an RuntimeException");
        assertEquals("Erudio", list.get(anyInt()));
    }
}
