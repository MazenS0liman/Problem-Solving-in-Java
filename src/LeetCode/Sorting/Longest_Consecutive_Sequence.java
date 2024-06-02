package LeetCode.Sorting;

import java.util.Arrays;

/*
    ----------------------------------------------------------------
    | Problem: Longest Consecutive Sequence
    | Link: https://leetcode.com/problems/longest-consecutive-sequence/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = 1;
        int count = 1;

        if (length == 0) return 0;

        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            }
            else if (nums[i] != nums[i - 1]) {
                if (count > max) max = count;
                count = 1;
            }
        }

        if (count > max) max = count;

        return max;
    }
}
