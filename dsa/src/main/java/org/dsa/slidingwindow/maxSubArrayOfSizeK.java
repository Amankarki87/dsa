package org.dsa.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’ , find the maximum sum of any contiguous subarray of size ‘k’ .
 *
 * Example 1 :-
 * nums : [2, 1, 5, 1, 3, 2]
 * k: 3
 * output : 9
 *
 * Example 2 :-
 * nums : [2, 3, 4, 1, 5]
 * k: 2
 * output: 7
 */
public class maxSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSubArray(nums,k));
    }

    private static int maxSubArray(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length;windowEnd ++) {
            windowSum += nums[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum,maxSum);
                windowSum -= nums[windowStart];
                windowStart ++;
            }
        }

        return maxSum;
    }
}
