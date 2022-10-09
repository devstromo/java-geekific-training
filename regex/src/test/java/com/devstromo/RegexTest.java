package com.devstromo;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.COMMENTS;
import static java.util.regex.Pattern.DOTALL;
import static java.util.regex.Pattern.LITERAL;
import static java.util.regex.Pattern.MULTILINE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class RegexTest {

    @Test
    public void testGroup() {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{4})(.*)([a-zA-Z]{9})$");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("LikeAndSubscribe");
        assertTrue(matcher.matches());
        assertEquals("Like", matcher.group(1));
        assertEquals("And", matcher.group(2));
        assertEquals("Subscribe", matcher.group(3));
        assertEquals("LikeAndSubscribe", matcher.group(0));
        assertEquals("LikeAndSubscribe", matcher.group());
    }

    // start/end return the starting / ending index of the matched subsequence or group
    @Test
    public void testStart() {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{4})(.*)([a-zA-Z]{9})$");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("LikeAndSubscribe");
        assertTrue(matcher.matches());
        assertEquals(0, matcher.start());
        assertEquals(7, matcher.start(3));
    }

    @Test
    public void testEnd() {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{4})(.*)([a-zA-Z]{9})$");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("LikeAndSubscribe");
        assertTrue(matcher.matches());
        assertTrue(matcher.matches());
        assertEquals(16, matcher.end());
        assertEquals(4, matcher.end(1));
    }

    // groupCount
    @Test
    public void testGroupCount() {
        Pattern pattern = Pattern.compile("^([a-zA-Z]{4})(.*)([a-zA-Z]{9})$");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("LikeAndSubscribe");
        assertTrue(matcher.matches());
        assertEquals(3, matcher.groupCount());
    }

    // replaceFirst / replaceAll
    @Test
    public void testReplaceFirst() {
        Pattern pattern = Pattern.compile("\\s");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("Like And Subscribe");
        assertTrue(matcher.find());
        assertEquals("Like_And Subscribe", matcher.replaceFirst("_"));
    }

    @Test
    public void testReplaceAll() {
        Pattern pattern = Pattern.compile("\\s");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("Like And Subscribe");
        assertTrue(matcher.find());
        assertEquals("Like_And_Subscribe", matcher.replaceAll("_"));
    }

    // escaping characters(meta-characters)
    @Test
    public void testEscapingCharacters() {
        Pattern pattern = Pattern.compile("\\.");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher(".");
        assertTrue(matcher.matches());
        regex = new Regex(pattern);
        matcher = regex.matcher("a");
        assertFalse(matcher.matches());
    }

    @Test
    public void testNotEscapingCharacters() {
        Pattern pattern = Pattern.compile(".");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher(".");
        assertTrue(matcher.matches());
        regex = new Regex(pattern);
        matcher = regex.matcher("a");
        assertTrue(matcher.matches());
    }

    @Test
    public void testPredefinedCharacterClasses() {
        Pattern pattern = Pattern.compile("\\d");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("123");
        assertTrue(matcher.find());
    }

    @Test
    public void testCaseInsensitive() {
        Pattern pattern = Pattern.compile("Like AND Subscribe", CASE_INSENSITIVE);
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("like and subscribe");
        assertTrue(matcher.matches());

        pattern = Pattern.compile("Like AND Subscribe");
        regex = new Regex(pattern);
        matcher = regex.matcher("like and subscribe");
        assertFalse(matcher.matches());

        pattern = Pattern.compile("(?i)Like AND Subscribe");
        regex = new Regex(pattern);
        matcher = regex.matcher("like and subscribe");
        assertTrue(matcher.matches());
    }

    @Test
    public void testCaseComments() {
        Pattern pattern = Pattern.compile("^like #Geekific", COMMENTS);
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("like and subscribe");
        assertTrue(matcher.find());

        pattern = Pattern.compile("(?x)^like #Geekific");
        regex = new Regex(pattern);
        matcher = regex.matcher("like and subscribe");
        assertTrue(matcher.find());
    }

    @Test
    public void testDotAll() {
        Pattern pattern = Pattern.compile("(.*)");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("like\ngeekfic");
        assertTrue(matcher.find());
        assertEquals("like", matcher.group(1));

        pattern = Pattern.compile("(.*)", DOTALL);
        regex = new Regex(pattern);
        matcher = regex.matcher("like\ngeekfic");
        assertTrue(matcher.find());
        assertEquals("like\ngeekfic", matcher.group(1));
    }

    // not special meaning
    @Test
    public void testLiteral() {
        Pattern pattern = Pattern.compile("(.*)");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("geekfic");
        assertTrue(matcher.matches());

        pattern = Pattern.compile("(.*)", LITERAL);
        regex = new Regex(pattern);
        matcher = regex.matcher("(.*)");
        assertTrue(matcher.matches());
    }

    @Test
    public void testMultiline() {
        Pattern pattern = Pattern.compile("^geekfic");
        Regex regex = new Regex(pattern);
        Matcher matcher = regex.matcher("like\ngeekfic");
        assertFalse(matcher.find());

        pattern = Pattern.compile("^geekfic", MULTILINE);
        regex = new Regex(pattern);
        matcher = regex.matcher("like\ngeekfic");
        assertTrue(matcher.find());

        pattern = Pattern.compile("(?m)^geekfic");
        regex = new Regex(pattern);
        matcher = regex.matcher("like\ngeekfic");
        assertTrue(matcher.find());
    }

}