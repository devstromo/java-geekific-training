package com.devstromo.data_compression.huffman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuffmanTest {

    @Test
    public void testHuffman() {
        Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");
        String encodedText = huffman.encode();
        System.out.println(encodedText);

        huffman.printCodes();

        String originalText = huffman.decode(encodedText);
        System.out.println(originalText);
        assertEquals("0000000011111111111111101101101101100100", encodedText);
        assertEquals("aaaaaaaabbbbbbbccccdd", originalText);
    }

}