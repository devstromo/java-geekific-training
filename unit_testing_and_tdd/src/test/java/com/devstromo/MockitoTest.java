package com.devstromo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @Mock
    List<String> mockList;

    @Spy
    List<String> spyList = new LinkedList<>();

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    void mock_list_returns_correct_element() {
        when(mockList.get(0)).thenReturn("Like");
        assertEquals("Like", mockList.get(0));
    }

    @Test
    void spy_list_adds_element_to_it_correctly() {
        // a spy is used to create a real object and spy on it
        // allows particular objects behave normally
        spyList.add("Subscribe");
        verify(spyList).add("Subscribe");
        assertEquals(1, mockList.size());
    }

    @Test
    void spy_list_adds_the_correct_element_to_it() {
        // captor is mainly used when the passed
        // argument is a complex object, and
        // deep assertions need to be done on it
        spyList.add("Geekfic");
        verify(spyList).add(captor.capture());
        assertEquals("Geekfic", captor.getValue());
    }
}
