package LeetCode.SlidingWindow;

/*
    ----------------------------------------------------------------
    | Problem: Longest Subarray of 1's After Deleting One Element
    | Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/


public class Longest_Subarray_of_1s_After_Deleting_One_Element {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int maxLength = 0;
        int k = -1, j = 0, i = 0;
        int length = nums.length;

        while(i < length) {
            if (nums[i] == 0) {
                j = k == -1 ? j : k + 1;
                k = i;
            }
            else {
                int currentLength = k == - 1 ? i - j + 1 : i - j;
                maxLength = Math.max(currentLength, maxLength);
            }

            i++;
        }

        // check list of all ones
        if (k == -1) {
            return length - 1;
        }

        return maxLength;
    }

}
