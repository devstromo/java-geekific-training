package com.devstromo.data_compression.lzw;

import static com.devstromo.data_compression.lzw.LZW.decode;
import static com.devstromo.data_compression.lzw.LZW.encode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LZWTest {

    @Test
    public void testLwsCompression() {
        List<Integer> compressed = encode("geekifc-geekific");
        assertEquals(13, compressed.size());
        assertEquals(Arrays.asList(103, 101, 101, 107, 105, 102, 99, 45, 256, 258, 260, 105, 99), compressed);
    }

    @Test
    public void testLwsCompressionDecode() {
        List<Integer> compressed = encode("geekifc-geekific");
        String decompressed = decode(compressed);
        encode("geekifc-geekific");
        assertFalse(decompressed.isEmpty());
        assertEquals("geekifc-geekific", decompressed);
    }

}