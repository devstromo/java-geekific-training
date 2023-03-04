package longest_substring_without_repeating;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingTest {


    @Test
    public void lengthOfLongestSubstring(){
        assertEquals(1, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }


    @Test
    public void lengthOfLongestSubstringDifferentLetters(){
        assertEquals(4, LongestSubstringWithoutRepeating.lengthOfLongestSubstring("aaaaaabbbaaaaaaaaaaaaacccaaC"));
    }

    @Test
    public void lengthOfLongestSubstringDifferentLettersUsingMap(){
        assertEquals(2, LongestSubstringWithoutRepeating.lengthOfLongestSubstringMap("aaaaaabbbaaaaaaaaaaaaacccaaC"));
    }

}