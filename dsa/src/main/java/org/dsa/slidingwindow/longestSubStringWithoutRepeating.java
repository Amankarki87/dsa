package org.dsa.slidingwindow;

import java.util.HashMap;

public class longestSubStringWithoutRepeating {
    // Given a string, str, return the length of the longest substring without repeating characters.
    // String - bbbbbb , output = 1
    // String - pwwkew, output = 2 (wke)
    // String - "", output = 0

    public static void main(String[] args) {
        longestSubString("abcdbea");
    }

    private static int longestSubString(String s) {
        if (s.equals("")) { return 0; }
        HashMap<Character,Integer> freqCount = new HashMap<Character,Integer>();
        int windowLength = 0;
        int windowStart = 0;
        int longest = 0;
        int i = 0;

        for (i =0; i < s.length();i++) {
            char character = s.charAt(i);

            if (freqCount.containsKey(character) && freqCount.get(character) >= windowStart) {
                windowLength = i - windowStart;
                if (longest < windowLength) {
                    longest = windowLength;
                }

                windowStart = freqCount.get(character) + 1;
            }

            freqCount.put(character,i);
        }

        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        System.out.println("longest is" + longest);
        return longest;
    }
}
