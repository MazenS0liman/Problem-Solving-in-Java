package LeetCode.Array;

import java.util.*;

/*
    ----------------------------------------------------------------
    | Problem: Kids With the Greatest Number of Candies
    | Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Kids_With_the_Greatest_Number_of_Candies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) { // O(n)
            boolean flag = true;
            int tmp = candies[i] + extraCandies;

            for (int j = 0; j < candies.length; j++) {
                if (tmp < candies[j]) {
                    flag = false;
                }
            }

            result.add(i, flag);
        }

        return result;
    }
}

