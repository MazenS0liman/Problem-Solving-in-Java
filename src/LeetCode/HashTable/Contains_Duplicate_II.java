package LeetCode.HashTable;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Contains Duplicate II
    | Link: https://leetcode.com/problems/contains-duplicate-ii
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hSet = new HashSet<>();
        int i = 0;
        int j = k;
        for (int t = i; t <= j && t < nums.length; t++) {
            if (hSet.contains(nums[t])) {
                return true;
            }
            else {
                hSet.add(nums[t]);
            }
        }

        j++;
        while (j < nums.length) {
            hSet.remove(nums[i]);
            i++;
            if (hSet.contains(nums[j])) {
                return true;
            }
            else {
                hSet.add(nums[j]);
            }
            j++;
        }

        return false;
    }
}
