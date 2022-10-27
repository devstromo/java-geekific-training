package com.devstromo.data_compression.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

    private Node root;
    private final String text;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> huffmanCodes;

    public Huffman(String text) {
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();
    }

    private void fillCharFrequenciesMap() {
        charFrequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            Integer integer = charFrequencies.get(character);
            charFrequencies.put(character, integer != null ? integer + 1 : 1);
        }
    }

    public String encode() {
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach(((character, frequency) -> queue.add(new Leaf(character, frequency))));
        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), queue.poll()));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedText();
    }

    public String decode(String encodedText) {
        StringBuilder builder = new StringBuilder();
        Node current = root;
        for (char character : encodedText.toCharArray()) {
            current = character == '0' ? current.getLeftNode() : current.getRightNode();
            if (current instanceof Leaf) {
                builder.append(((Leaf) current).getCharacter());
                current = root;
            }
        }
        return builder.toString();
    }

    public void printCodes() {
        huffmanCodes.forEach((character, code) -> System.out.println(character + " : " + code));
    }

    private void generateHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf) {
            huffmanCodes.put(((Leaf) node).getCharacter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    private String getEncodedText() {
        StringBuilder builder = new StringBuilder();
        for (char character : text.toCharArray()) {
            builder.append(huffmanCodes.get(character));
        }
        return builder.toString();
    }

}
