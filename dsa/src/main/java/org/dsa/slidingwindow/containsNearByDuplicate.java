package org.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Example1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Leetcode :- https://leetcode.com/problems/contains-duplicate-ii/description/
 */

public class containsNearByDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 2;

        System.out.println(duplicate(nums,k));
    }

    private static boolean duplicate(int[] nums, int k) {
        int size = nums.length;
        if (size == 0 || size == 1) {
            return false;
        }

        Set<Integer> hashData = new HashSet<>();

        for (int i = 0; i < size; i ++) {

            if (hashData.contains(nums[i])) {
                return true;
            }

            hashData.add(nums[i]);
            if (hashData.size() > k) {
                hashData.remove(nums[i - k]);
            }
        }

        return false;
    }
}
