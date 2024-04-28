package org.dsa.slidingwindow;

public class MinSizeSubArraySum {
    // Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a
    // contiguous subarray whose sum is greater than or equal to the target.
    // If no such subarray is found, return 0.
    // ex:- nums - [2,3,1,2,4,3] and target - 7
    // output - 2 (by adding 4 and 3)
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        minSizeSubArraySum(nums,7);
    }

    private static int minSizeSubArraySum(int[] nums,int target) {
        int start = 0;
        int sum = 0;
        int windowSize = Integer.MAX_VALUE;
        int currentWindowSize = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                currentWindowSize = end - start + 1;
                windowSize = Math.min(currentWindowSize,windowSize);

                sum -= nums[start];
                start ++;
            }

        }

        if (windowSize != Integer.MAX_VALUE) {
            return windowSize;
        }

        return 0;
    }
}
