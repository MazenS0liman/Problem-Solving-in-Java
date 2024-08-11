package LeetCode.DynamicProgramming;
import java.util.*;

/*
    ----------------------------------------------------------------
    | Problem: Pascal's Triangle
    | Link: https://leetcode.com/problems/pascals-triangle/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            output.add(new ArrayList<>());
            List<Integer> row = output.get(i);

            for (int j = 0; j <= i; j++) {
                row.add(0);
            }

            row.set(0, 1);
            row.set(i, 1);
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> prevRow = output.get(i - 1);
            List<Integer> row = output.get(i);
            for (int j = 1; j < i; j++) {
                row.set(j, prevRow.get(j) + prevRow.get(j - 1));
            }
        }

        return output;
    }
}
