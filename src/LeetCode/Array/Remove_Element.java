package LeetCode.Array;

/*
    ----------------------------------------------------------------
    | Problem: Remove Element
    | Link: https://leetcode.com/problems/remove-element
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Remove_Element {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    count++;
                    j--;
                }
                else {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    j--;
                    i++;
                    count++;
                }
            }
            else {
                i++;
            }
        }

        return nums.length - count;
    }
}
