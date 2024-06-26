package org.dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class findMaximum {

    // naive approach
    public static int[] findMaximumInSlidingWindow(int[] nums, int w) {
        int length = nums.length;

        if (length == 1) {
            return nums;
        }

        int [] output = new int[length - w + 1];

        for (int i = 0; i < length - w + 1;i++) {
            int maxNumber = nums[i];
            int counter = 0;

            for (int j = 0;j < w; j++) {
                if (maxNumber < nums[i + j]) {
                    maxNumber = nums[i + j];
                }

                counter += 1;
            }

            output[i] = maxNumber;
            System.out.println("Output at index " +i + "is "+ output[i]);
            counter = 0;
        }

        return output;
    }

    // sliding window using ArrayList
    public static int[] findmax(int [] nums, int w) {

        int length = nums.length;

        if (nums.length == 1) {
            return nums;
        }

        ArrayList<Integer> currentWindow = new ArrayList<Integer>();
        int[] output = new int[]{length - w +1};

        for (int i = 0;i< w;i++) {
            cleanup(i,currentWindow,nums);
            currentWindow.add(i);
        }

        // [1,2,3,4,5,6,7,8,9,10], w=3

        // currentWindow -> [0,1,2]
        // output => []
        output[0] = nums[currentWindow.get(0)];

        for (int i = w; i < length; i++) {
            cleanup(i,currentWindow,nums);

            if (!currentWindow.isEmpty() && currentWindow.get(0) <= (i - w)) {
                currentWindow.remove(0);
            }

            currentWindow.add(i);

            output[i - w] = nums[currentWindow.get(0)];
        }

        return output;
    }

    // sliding window using deque
    public static int[] findMaxUsingDeque(int[] nums, int w) {
        int length = nums.length;

        if (length == 1) {
            return nums;
        }

        int[] output = new int[length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();

        for (int i = 0; i < w;i++) {
            cleanup(i,currentWindow,nums);
            currentWindow.add(i);
        }

        output[0] = nums[currentWindow.getFirst()];
        System.out.println("output at 0th index is " +nums[currentWindow.getFirst()]);

        for (int i = w;i< length;i++) {
            cleanup(i,currentWindow,nums);

            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                currentWindow.removeFirst();
            }

            currentWindow.add(i);
            output[i-w + 1] = nums[currentWindow.getFirst()];

            int currentIndex = i - w + 1;
            System.out.println("output at " + currentIndex + " value is " +nums[currentWindow.getFirst()]);
        }

        return output;
    }

    private static Deque<Integer> cleanup(int index,Deque<Integer> currentWindow,int [] nums) {
        while (currentWindow.size() != 0 && nums[index] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }

        return currentWindow;
    }
    private static ArrayList<Integer> cleanup(int index,ArrayList<Integer> currentWindow,int [] nums) {
        while (currentWindow.size() != 0 && nums[index] >= nums[currentWindow.get(currentWindow.size() - 1)]) {
            currentWindow.remove(currentWindow.size() - 1);
        }

        return currentWindow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,-1};
        int window = 1;

        findMaxUsingDeque(arr,window);
    }

}

// Given an integer array nums, find the maximum values in all the contiguous subarrays (windows) of size w.
// Example: 1
// nums = [-4,2,-5,3,6], window size = 3
// 2,3,6
// Example: 2
// nums = [1,2,3,4,5,6], window size = 6
// 6

