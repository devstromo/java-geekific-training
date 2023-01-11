package com.devstromo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

    @Mock
    private MyRepository repository;

    @Mock
    private OtherService otherService;

    @InjectMocks
    private MyService myService;

    @Test
    void myService_calls_otherService_correctly() throws InvalidMyObjectException {
        MyObject myObject = new MyObject();
        when(repository.getById(any())).thenReturn(myObject);
        myService.getAsJsonString(UUID.randomUUID());
        verify(otherService).myObjectToJson(myObject);
    }

    @Test
    void myService_throws_InvalidMyObjectException() throws InvalidMyObjectException {
        when(otherService.myObjectToJson(any())).thenThrow(new InvalidMyObjectException());
        assertThrows(InvalidMyObjectException.class, () -> myService.getAsJsonString(UUID.randomUUID()));
    }

    @Test
    void test_ThenReturn() {
        MyObject object = mock(MyObject.class);
        when(object.doStuff(anyString())).thenReturn(10);
        assertEquals(10, object.doStuff("Like"));
    }

    @Test
    void test_ThenAnswer() {
        MyObject object = mock(MyObject.class);
        Answer<Integer> answer = invocation -> {
            String arg = invocation.getArgument(0);
            return arg.length() * 4;
        };
        when(object.doStuff(anyString())).thenAnswer(answer);
        assertEquals(16, object.doStuff("Like"));
    }
}