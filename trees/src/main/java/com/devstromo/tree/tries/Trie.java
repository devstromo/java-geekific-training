package com.devstromo.tree.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie implements Tree {

    private final Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    @Override
    public Tree insert(String word) {
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                currentNode = children.get(c);
            } else {
                currentNode = new Node(c);
                children.put(c, currentNode);
            }
            children = currentNode.getChildren();
        }
        currentNode.setEndOfWord(true);
        return this;
    }

    @Override
    public boolean contains(String word) {
        Node lastPresentNode = search(word);
        return lastPresentNode != null && lastPresentNode.isEndOfWord();
    }

    @Override
    public void delete(String word) {
        List<Node> list = new ArrayList<>();
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (!children.containsKey(c)) {
                return;
            }
            Node currentNode = children.get(c);
            children = currentNode.getChildren();
            list.add(currentNode);
        }
        if (list.isEmpty() || list.size() != word.length()) {
            return;
        }

        // avoid remove contained words
        list.get(list.size() - 1)
            .setEndOfWord(false);
        // remove only no contained characters
        for (int i = list.size() - 1; i > 0; i--) {
            Node current = list.get(i);
            if (current.getChildren()
                .isEmpty()) {
                list.get(i - 1)
                    .getChildren()
                    .remove(current.getCharacter());
            } else if (current.isEndOfWord()) {
                break;
            }
        }

    }

    @Override
    public boolean containsPrefix(String prefix) {
        return search(prefix) != null;
    }

    @Override
    public List<String> wordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        Node prefixNode = search(prefix);
        if (prefixNode != null) {
            addWords(prefixNode, prefix, words);
        }
        return words;
    }

    private void addWords(Node node, String word, List<String> wordsList) {
        if (node.isEndOfWord()) {
            wordsList.add(word);
        }

        node.getChildren()
            .values()
            .forEach(child -> {
                String character = String.valueOf(child.getCharacter());
                addWords(child, word.concat(character), wordsList);
            });
    }

    private Node search(String str) {
        Node currentNode = null;
        Map<Character, Node> children = root.getChildren();
        for (char c : str.toCharArray()) {
            if (!children.containsKey(c)) {
                return null;
            }
            currentNode = children.get(c);
            children = currentNode.getChildren();
        }
        return currentNode;
    }
}
