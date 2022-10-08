package com.devstromo.tree.tries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    public void testInsertion() {
        Tree trie = new Trie();
        trie.insert("develop")
            .insert("developing")
            .insert("developer")
            .insert("development")
            .insert("device")
            .insert("apple")
            .insert("application")
            .insert("applicative")
            .insert("appletv")
            .insert("ape")
            .insert("band");
        assertTrue(trie.contains("appletv"));
    }

    @Test
    public void testDelete() {
        Tree trie = new Trie();
        trie.insert("develop")
            .insert("developing")
            .insert("developer")
            .insert("development")
            .insert("device")
            .insert("apple")
            .insert("application")
            .insert("applicative")
            .insert("appletv")
            .insert("ape")
            .insert("band");
        trie.delete("apple");
        assertFalse(trie.contains("apple"));
        assertTrue(trie.contains("appletv"));
    }

    @Test
    public void testWordsWithPrefix() {
        Tree trie = new Trie();
        trie.insert("develop")
            .insert("developing")
            .insert("developer")
            .insert("development")
            .insert("device")
            .insert("apple")
            .insert("application")
            .insert("applicative")
            .insert("appletv")
            .insert("ape")
            .insert("band");
        List<String> words = trie.wordsWithPrefix("app");
        assertFalse(words.isEmpty());
        assertEquals(4, words.size());
    }


    @Test
    public void testContainsPrefixPrefix() {
        Tree trie = new Trie();
        trie.insert("develop")
            .insert("developing")
            .insert("developer")
            .insert("development")
            .insert("device")
            .insert("apple")
            .insert("application")
            .insert("applicative")
            .insert("appletv")
            .insert("ape")
            .insert("band");
        assertTrue(trie.containsPrefix("ban"));
    }

    @Test
    public void testNotContainsPrefixPrefix() {
        Tree trie = new Trie();
        trie.insert("develop")
            .insert("developing")
            .insert("developer")
            .insert("development")
            .insert("device")
            .insert("apple")
            .insert("application")
            .insert("applicative")
            .insert("appletv")
            .insert("ape")
            .insert("band");
        assertFalse(trie.containsPrefix("hello"));
    }
}