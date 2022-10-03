package com.devtstromo.data_compression;

import java.util.regex.Pattern;

public class RunLengthEncoding {

    public static String compress(String text) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        pattern.matcher(text)
            .results()
            .forEach(result -> {
                int repetitions = result.group(1)
                    .length();
                builder.append(result.group(2))
                    .append(repetitions);
            });
        return builder.toString();
    }

    public static String decompress(String text) {
        StringBuilder builder = new StringBuilder();

        Pattern pattern = Pattern.compile("([a-zA-Z])([0-9]*)");
        pattern.matcher(text)
            .results()
            .forEach(result -> {
                int count = Integer.parseInt(result.group(2));
                builder.append(result.group(1)
                    .repeat(count));
            });
        return builder.toString();
    }
}
