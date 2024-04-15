package org.dsa.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNA {
    public static Set<String> findOccurences(String s, int k) {
        int length = s.length();

        if (length < k) {
            return new HashSet<>();
        }

        Set<String> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        // 0(n * k -1)

        for (int i = 0; i < length - k + 1; i++) {
            String sequence = "";
            int counter = i;
            for (int j = 0; j < k; j++) {
                sequence += s.charAt(counter);
                counter++;
            }

            if (hashSet.contains(sequence)) {
                output.add(sequence);
            }

            hashSet.add(sequence);
        }

        System.out.println("output is" + output);
        return output;
    }

    public static void main(String[] args) {
        findOccurences("AGCTGAAAGCTTAGCTG",5);
    }
}










// Given a string, s, that represents a DNA subsequence, and a number k, return all the contiguous subsequences (substrings) of length
// that occur more than once in the string. The order of the returned subsequences does not matter.
// If no repeated substring is found, the function should return an empty set.