package LeetCode.HashTable;

import java.util.Arrays;
import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Two Sum
    | Link: https://leetcode.com/problems/two-sum/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Two_Sum {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hTable = new Hashtable<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) { // O(n)
            int key = target - nums[i];
            if (hTable.containsKey(key)) {
                int index = hTable.get(key);
                result[0] = index;
                result[1] = i;
                break;
            }
            else {
                hTable.put(nums[i], i);
            }
        }

        return result;
    }
}
