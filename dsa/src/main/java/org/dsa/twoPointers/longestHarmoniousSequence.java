package org.dsa.twoPointers;

import java.util.HashMap;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 * Leetcode :- https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 */

public class longestHarmoniousSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,5,1,1,1,1};
        findHarmoniousSequence(nums);
    }

    private static int findHarmoniousSequence(int[] nums) {
        HashMap<Integer, Integer> harmonious = new HashMap<Integer,Integer>();

        for (int num: nums) {
            harmonious.put(num, harmonious.getOrDefault(num, 0) + 1);
        }

        int result = 0;

        for (int key: harmonious.keySet()) {
            if (harmonious.containsKey(key + 1)) {
                result = Math.max(result,harmonious.get(key) + harmonious.get(key + 1));
            }
        }

        System.out.println("result is" + result);

        return result;
    }
}
