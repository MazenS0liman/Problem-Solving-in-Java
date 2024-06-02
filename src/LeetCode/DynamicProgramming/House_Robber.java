package LeetCode.DynamicProgramming;

/*
    ----------------------------------------------------------------
    | Problem: House Robber
    | Link: https://leetcode.com/problems/house-robber
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class House_Robber {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = dp[i - 1] + nums[i];
            dp[i + 1] = dp[i + 1] > dp[i] ? dp[i + 1] : dp[i];
        }

        return dp[length];
    }
}
