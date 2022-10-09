package com.devstromo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private final Pattern pattern;

    public Regex(Pattern pattern) {
        this.pattern = pattern;
    }

    public Matcher matcher(String expression) {
        return pattern.matcher(expression);
    }
}
