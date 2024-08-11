package LeetCode.HashTable;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Happy Number
    | Link: https://leetcode.com/problems/happy-number
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Happy_Number {

    public boolean isHappy(int n) {
        if (n == 0) return false;
        else if (n == 1) return true;
        else {
            HashSet<Integer> set = new HashSet<>();

            while (!set.contains(n)) {
                set.add(n);
                int sum = 0;
                while (n != 0) {
                    sum += (int) Math.pow(n % 10, 2);
                    n = n / 10;
                }

                n = sum;
            }

            return n == 1;
        }
    }
}

