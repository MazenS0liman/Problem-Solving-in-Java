package LeetCode.DynamicProgramming;

/*
    ----------------------------------------------------------------
    | Problem: House Robber II
    | Link: https://leetcode.com/problems/house-robber-ii
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class House_Robber_II {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++) {
            arr1[i] = nums[i];
        }

        for(int i = 1; i < nums.length; i++) {
            arr2[i - 1] = nums[i];
        }

        int max1 = helper(arr1);
        int max2 = helper(arr2);

        return Math.max(max1, max2);
    }

    public int helper(int[] nums) {
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
