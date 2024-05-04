package org.dsa.twoPointers;
/**
 * Given two version numbers, version1 and version2, compare them.
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Leetcode :-
 */

public class compareVersion {
    public static void main(String[] args) {
        compareVersion("1.0", "1.0.0");
    }

    private static int compareVersion(String version1, String version2) {
        int v1Size = version1.length();
        int v2Size = version2.length();

        int i = 0;
        int j = 0;

        while (i < v1Size && j < v2Size) {
            int num1 = 0;
            int num2 = 0;

            while (i < v1Size && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i ++;
            }

            while (j < v2Size && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }

            int result = compare(num1,num2);
            if (result != 0) {
                System.out.println("result is " + result);
                return result;
            }

            i ++;
            j ++;
        }

        System.out.println("result is " + 0);
        return 0;
    }

    private static int compare(int num1, int num2) {
        if (num1 == num2) return 0;
        return num1 > num2 ? 1 : -1;
    }


}
