package org.dsa.slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public static int longestRepeatingCharacter(String s, int k) {
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> characterFrequencies = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int lengthOfMaxSubString = 0;

        while (end < s.length()) {
            char singleCharacter = s.charAt(end);
            characterFrequencies.put(singleCharacter,characterFrequencies.getOrDefault(singleCharacter,0) + 1);
            maxFreq = Math.max(maxFreq,characterFrequencies.get(singleCharacter));

            if (end - start + 1 - maxFreq > k ) {
                characterFrequencies.put(s.charAt(start),characterFrequencies.get(s.charAt(start)) - 1);
                start += 1;
            }

            lengthOfMaxSubString = Math.max(lengthOfMaxSubString, end - start + 1);
            end += 1;
        }

        System.out.println("Length of max substring" + lengthOfMaxSubString);
        return lengthOfMaxSubString;
    }

    public static void main(String[] args) {
        longestRepeatingCharacter("aabccbb",2);
    }

}

// Given a string s and an integer k, find the length of the longest substring in s, where all characters are identical,
// after replacing, at most, k characters with any other lowercase English character.
// String s = "aabccbb"
// k = 2
