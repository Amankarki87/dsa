package org.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = new int[]{1,2,1};
        fruitIntoBaskets(fruits);
    }

    private static int fruitIntoBaskets(int[] fruits) {
        int windowStart = 0;
        int windowLength = 0;
        Map<Integer,Integer> charFrequencies = new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd ++) {
            int fruit = fruits[windowEnd];

            if (!charFrequencies.containsKey(fruit)) {
                charFrequencies.put(fruit, 0);
            }

            charFrequencies.put(fruit, charFrequencies.get(fruit) + 1);

            while (charFrequencies.keySet().size() > 2) {
                int startingFruit = charFrequencies.get(fruits[windowStart]);
                charFrequencies.put(fruits[windowStart], startingFruit - 1);

                if (charFrequencies.get(fruits[windowStart]) == 0) {
                    charFrequencies.remove(fruits[windowStart]);
                }

                windowStart ++;
            }

            windowLength = Math.max(windowLength,windowEnd - windowStart + 1);
        }

        System.out.println("window length is" + windowLength);
        return windowLength;
    }
}
