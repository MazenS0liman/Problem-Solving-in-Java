package LeetCode.DynamicProgramming;
import java.util.*;

/*
    ----------------------------------------------------------------
    | Problem: Triangle
    | Link: https://leetcode.com/problems/triangle
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Traingle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();

        for (List<Integer> integers : triangle) {
            List<Integer> row = new ArrayList<>();
            dp.add(row);

            for (int j = 0; j < integers.size(); j++) {
                row.add(Integer.MAX_VALUE);
            }
        }

        if (!triangle.isEmpty()) {
            dp.get(0).set(0, triangle.get(0).get(0));
        }

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp.get(i).set(j, Math.min(Math.min(i != j ? triangle.get(i).get(j) + dp.get(i - 1).get(j) : Integer.MAX_VALUE, dp.get(i).get(j)), j - 1 >= 0 ? triangle.get(i).get(j) + dp.get(i - 1).get(j - 1) : Integer.MAX_VALUE));
            }
        }

        int lastRowIndex = dp.size() - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(lastRowIndex).size(); i++) {
            System.out.println(dp.get(lastRowIndex).get(i) + " ");
            if (dp.get(lastRowIndex).get(i) < min) {
                min = dp.get(lastRowIndex).get(i);
            }
        }

        return min;
    }

}
