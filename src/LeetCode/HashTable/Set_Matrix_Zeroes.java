package LeetCode.HashTable;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Set Matrix Zeroes
    | Link: https://leetcode.com/problems/set-matrix-zeroes
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> columnNumbers = new HashSet<>();
        HashSet<Integer> rowNumbers = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    columnNumbers.add(j);
                    rowNumbers.add(i);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowNumbers.contains(i) || columnNumbers.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
