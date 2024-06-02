package LeetCode.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
    ----------------------------------------------------------------
    | Problem: Rotting Oranges
    | Link: https://leetcode.com/problems/rotting-oranges
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Rotting_Oranges {
    public static int orangesRotting(int[][] grid) {
       // check if there is no rotten oranges then return 0
        boolean foundNoRotten = false;
        Queue<Pair> queue = new LinkedList<Pair>();
        int minutes = 0;
        int rowsLength = grid.length;
        int columnsLength = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    foundNoRotten = true;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        if (!foundNoRotten) {
            return 0;
        }

        while (!queue.isEmpty()) {
            Queue<Pair> tmp = new LinkedList<>();
            boolean rotten = false;
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                if (pair.i - 1 >= 0 && grid[pair.i - 1][pair.j] == 1) {
                    grid[pair.i - 1][pair.j] = 2;
                    tmp.add(new Pair(pair.i - 1, pair.j));
                    rotten = true;
                }
                if (pair.i + 1 < rowsLength && grid[pair.i + 1][pair.j] == 1) {
                    grid[pair.i + 1][pair.j] = 2;
                    tmp.add(new Pair(pair.i + 1, pair.j));
                    rotten = true;
                }
                if (pair.j - 1 >= 0 && grid[pair.i][pair.j - 1] == 1) {
                    grid[pair.i][pair.j - 1] = 2;
                    tmp.add(new Pair(pair.i, pair.j - 1));
                    rotten = true;
                }
                if (pair.j + 1 < columnsLength && grid[pair.i][pair.j + 1] == 1) {
                    grid[pair.i][pair.j + 1] = 2;
                    tmp.add(new Pair(pair.i, pair.j + 1));
                    rotten = true;
                }
            }

            if (rotten) {
                minutes++;
            }
            queue = tmp;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
