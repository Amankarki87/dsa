package org.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class longestCharacterWithKDistinct {
    public static void main(String[] args) {
        longestSubstringWithKdistinct("cbbebi",3);
    }

    private static int longestSubstringWithKdistinct(String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFreq = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {
            char character = str.charAt(windowEnd);

            if ( !charFreq.containsKey(character)) {
                charFreq.put(character,0);
            }

            charFreq.put(character,charFreq.get(character) + 1);

            while (charFreq.keySet().size() > k) {
                char startCharacter = str.charAt(windowStart);

                charFreq.put(startCharacter, charFreq.get(startCharacter) - 1);

                if (charFreq.get(startCharacter) == 0) {
                    charFreq.remove(startCharacter);
                }

                windowStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        System.out.println("maximum length is" +maxLength);
        return maxLength;
    }
}
