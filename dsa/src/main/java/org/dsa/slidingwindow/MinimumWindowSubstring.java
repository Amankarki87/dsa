package org.dsa.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        minWindow("ABCD","ABC");
    }

    private static void minimumWindow(String s, String t) {
        int str1Idx = 0;
        int str2Idx = 0;
        int start = 0;
        int end = 0;
        float minLength = Float.POSITIVE_INFINITY;
        String subsequence = "";
        int str1Length = s.length();
        int str2Length = t.length();

        while (str1Idx < str1Length) {
            if (s.charAt(str1Idx) == t.charAt(str2Idx)) {
                str2Idx += 1;

                if (str2Idx == str2Length) {
                    start = str1Idx;
                    end = str1Idx;
                    str2Idx -= 1;

                    while (str2Idx >= 0) {
                        if (s.charAt(start) == t.charAt(str2Idx)) {
                            str2Idx -= 1;
                        }

                        start -= 1;
                    }

                    start += 1;

                    if (end - start + 1 < minLength) {
                        minLength = end - start + 1;
                        subsequence = s.substring(start, end + 1);
                    }

                    str1Idx += 1;
                    str2Idx = 0;
                }
            }

            str1Idx += 1;
        }

        System.out.println("subsequence is" +subsequence);
    }

    private static String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }

        HashMap<Character,Integer> freqCount = new HashMap<Character,Integer>();
        // Default window
        HashMap<Character,Integer> window = new HashMap<Character,Integer>();

        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            freqCount.put(character, 1 + freqCount.getOrDefault(character,0));
            window.put(character,0);
        }

        int left = 0;
        int right = 0;

        int required = freqCount.size();
        int current = 0;
        int[] res = {-1,-1};
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rightCharacter = s.charAt(right);

            if (freqCount.containsKey(rightCharacter)) {
                window.put(rightCharacter, window.getOrDefault(rightCharacter,0) + 1);
            }

            if (window.containsKey(rightCharacter) && window.get(rightCharacter).equals(freqCount.get(rightCharacter))) {
                current += 1;
            }

            while (current == required) {
                if ((right - left + 1) < minLength) {
                    res[0] = left;
                    res[1] = right;
                    minLength = right - left + 1;
                }

                char leftChar = s.charAt(left);

                if (freqCount.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                if (freqCount.containsKey(leftChar) && window.get(leftChar) < freqCount.get(leftChar)) {
                    current -= 1;
                }

                left ++;
            }

            right ++;
        }

        String result = (minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1));

        System.out.println(result);

        return result;
    }
}
