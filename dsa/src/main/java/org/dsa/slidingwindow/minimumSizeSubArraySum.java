package org.dsa.slidingwindow;

public class minimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,4};
        System.out.println(minSubArray(nums, 4));
    }


    // Approach 1
    private static int minSizeSubArraySum(int[] nums, int target) {
        int size = nums.length;

        if (size < 1) return 0;

        int windowSum = nums[0];
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowEnd = 1;

        while (windowStart < windowEnd && windowEnd < size) {

            windowSum += nums[windowEnd];

            while (windowSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart ++;
            }

            windowEnd ++;

        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }

    private static int minSubArray(int[] nums, int target) {
        int windowStart = 0;
        int windowEnd = 0;

        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int length = 0;

        while (windowEnd < nums.length) {
            if (windowSum < target) {
                windowSum = windowSum + nums[windowEnd];
                length ++;
                windowEnd ++;
            }

            if (windowSum >= target) {
                minLength = Math.min(minLength, length);
                windowSum -= nums[windowStart];
                windowStart++;
                length--;
            }
        }

        while (windowSum >= target) {
            minLength = Math.min(minLength, length);
            windowSum -= nums[windowStart];
            windowStart++;
            length --;
        }

        if (minLength == Integer.MAX_VALUE) return 0;

        return minLength;
    }
}
