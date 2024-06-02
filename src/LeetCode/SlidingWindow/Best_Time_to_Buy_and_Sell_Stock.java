package LeetCode.SlidingWindow;

/*
    ----------------------------------------------------------------
    | Problem: Best Time to Buy and Sell Stock
    | Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int maxDiffValue = 0;
        int minValue = prices[0];

        for (int i : prices) {
            if (i < minValue) {
                minValue = i;
            }
            else {
                if (i - minValue > maxDiffValue) {
                    maxDiffValue = i - minValue;
                }
            }
        }

        return maxDiffValue;
    }

}
