package LeetCode.HashTable;

import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Majority Element
    | Link: https://leetcode.com/problems/majority-element
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Majority_Element {

    public int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> hTable = new Hashtable<>();

        for (int num : nums) {
            if (hTable.containsKey(num)) {
                hTable.put(num, hTable.get(num) + 1);
            }
            else {
                hTable.put(num, 1);
            }
        }

        int max = 0;
        int majority = 0;

        for (int num : nums) {
            int tmp = hTable.get(num);

            if (tmp > max) {
                majority = num;
                max = tmp;
            }
        }

        return majority;
    }
}
