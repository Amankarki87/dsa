package org.dsa.slidingwindow;

// Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
// Example1
// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

public class MaximumAverage {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        averageSubArray(nums, 4);
    }

    private static float averageSubArray(int[] nums, int k) {
        int size = nums.length;

        if (size == 1) {
            return nums[0];
        }

        float maxAverage = Integer.MIN_VALUE;
        float sum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < size; windowEnd ++) {
            sum += nums[windowEnd];

            if ((windowEnd - windowStart + 1) == k) {
                maxAverage = Math.max(maxAverage,sum/k);
                sum -= nums[windowStart];
                windowStart ++;
            }
        }

        System.out.println("Max average is" +maxAverage);
        return maxAverage;
    }
}
