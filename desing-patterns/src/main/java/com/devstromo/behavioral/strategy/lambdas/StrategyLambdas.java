package com.devstromo.behavioral.strategy.lambdas;

import java.util.List;
import java.util.function.Predicate;

public class StrategyLambdas {
    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
            .filter(selector)
            .mapToInt(e -> e)
            .sum();
    }
}
