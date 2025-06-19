package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListWithBDDTest {
    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentsMatcher_ShouldReturn() {
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("Erudio");

        assertThat(list.get(anyInt()), is("Erudio"));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn(new RuntimeException("Foo Bar"));

        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should have throw an RuntimeException");
        assertThat(list.get(anyInt()), is("Erudio"));
    }
}
