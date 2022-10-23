package com.devstromo.behavioral.strategy.lambdas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class StrategyLambdasTest {

    private List<Integer> numbers = IntStream.range(0, 11)
        .boxed()
        .toList();

    @Test
    public void testTotalValues() {
        int total = StrategyLambdas.totalValues(numbers, ignore -> true);
        assertEquals(55, total);
    }

    @Test
    public void testTotalOddValues() {
        int total = StrategyLambdas.totalValues(numbers, value -> value % 2 != 0);
        assertEquals(25, total);
    }

    @Test
    public void testTotalEvenValues() {
        int total = StrategyLambdas.totalValues(numbers, value -> value % 2 == 0);
        assertEquals(30, total);
    }

}