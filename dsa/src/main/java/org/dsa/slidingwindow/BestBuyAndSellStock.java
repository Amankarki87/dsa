package org.dsa.slidingwindow;
// Given an array where the element at the index i represents the price of a stock on day i,
// find the maximum profit that you can gain by buying the stock once and then selling it.

// Note: You can buy the stock on one specific day and sell it on a different day to make a profit.
// If no profit can be achieved, we return zero.
// example :- prices - [7,1,5,3,6,4]
// output : // profit = 5

// example1 :- prices - [10,8,6,4,2]
// output : // profit = 0

public class BestBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0,9};
        buyAndSellStock(prices);
    }

    // Approach1
    private static int bestBuyAndSellStock(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length;i++) {
            if (prices[i] < minValue)  {
                minValue = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minValue);
            }
        }

        System.out.println("Maximum profit is" + maxProfit);
        return maxProfit;
    }

    public static int buyAndSellStock(int[] prices) {
        int maxProfit = 0;
        int buy = 0, sell = 1;

        while (sell < prices.length) {

            if (prices[buy] < prices[sell]) {
                int currentProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit,currentProfit);
                sell ++;
            } else {
                buy = sell;
                sell ++;
            }
        }

        return maxProfit;
    }
}
