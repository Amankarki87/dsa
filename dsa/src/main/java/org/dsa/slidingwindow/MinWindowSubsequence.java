package org.dsa.slidingwindow;

public class MinWindowSubsequence {
    // Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.

    public static String minimumSubsequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int str1Index = 0;
        int str2Index = 0;

        int start = 0;
        int end = 0;
        float minLength = Float.POSITIVE_INFINITY;
        String subsequence = "";

        while (str1Index < str1Length) {
            if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
                str2Index += 1;
                if (str2Index == str2Length) {
                    start = str1Index;
                    end = str1Index;
                    str2Index -= 1;

                    while (str2Index >= 0) {
                        if (str1.charAt(start) == str2.charAt(str2Index)) {
                            str2Index -= 1;
                        }

                        start -= 1;
                    }

                    start += 1;
                    if ((end - start + 1) < minLength ) {
                        minLength = end - start + 1;
                        subsequence = str1.substring(start,end + 1);
                    }

                    str1Index = start + 1;
                    str2Index = 0;
                }
            }

            str1Index += 1;
        }

        System.out.println(subsequence);
        return subsequence;
    }

    public static void main(String[] args) {
        String str1 = "ababcb";
        String str2 = "ac";
        minimumSubsequence(str1,str2);
    }
}
