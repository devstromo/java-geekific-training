package com.devtstromo.data_compression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RunLengthEncodingTest {

    @Test
    public void testCompress() {
        String initialText = "AAAABBBBBCCCCCCDDDDDDD";
        assertEquals("A4B5C6D7", RunLengthEncoding.compress(initialText));
    }

    @Test
    public void testDecompress() {
        String initialText = "A4B5C6D7";
        assertEquals("AAAABBBBBCCCCCCDDDDDDD", RunLengthEncoding.decompress(initialText));
    }

}