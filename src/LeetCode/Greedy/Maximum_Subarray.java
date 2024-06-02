package LeetCode.Greedy;

/*
    ----------------------------------------------------------------
    | Problem: Maximum Subarray
    | Link: https://leetcode.com/problems/maximum-subarray/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int cumulativeSum = largestSum;
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            int currentValue = nums[i];
            cumulativeSum = cumulativeSum < 0 ? 0 : cumulativeSum;
            cumulativeSum = cumulativeSum + currentValue;
            largestSum = largestSum > cumulativeSum ? largestSum : cumulativeSum;
        }

        return largestSum;
    }
}
