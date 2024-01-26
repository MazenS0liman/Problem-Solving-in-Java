package LeetCode.Array;

/*
    ----------------------------------------------------------------
    | Problem: K Divisible Elements Subarrays
    | Link: https://leetcode.com/contest/weekly-contest-291/problems/k-divisible-elements-subarrays/
    | Status: Continue
    ----------------------------------------------------------------
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class K_Divisible_Elements_Subarrays {

    public static void main(String[] args) {

    }

    /*public int countDistinct(int[] nums, int k, int p) {
        Hashtable<Integer, ArrayList<ArrayList<Integer>>> hTable = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> v = new ArrayList<>();
            int occurrence = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p != 0) {
                    v.add(nums[j]);
                    ArrayList<Integer> tmp = new ArrayList<>(v);

                    hTable.get(tmp.size()).add(tmp);
                }
                else if (nums[j] % p == 0 && occurrence + 1 <= k) {
                    v.add(nums[j]);
                    ArrayList<Integer> tmp = new ArrayList<>(v);


                    hTable.get(tmp.size()).add(tmp);
                    occurrence++;
                }
                else {
                    break;
                }
            }
        }


    }*/
}
