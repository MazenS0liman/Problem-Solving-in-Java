package LeetCode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid1));
    }

    public static int numIslands(char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int countIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Integer.parseInt(grid[i][j] + "") == 1 && !visited[i][j]) {
                    queue.add(new Pair(i, j));
                    countIslands++;
                }

                while (!queue.isEmpty()) {
                    Pair current = queue.poll();
                    visited[current.row][current.column] = true;
                    // check left boundary
                    if (current.row - 1 >= 0 && Integer.parseInt(grid[current.row - 1][current.column] + "") == 1 && !visited[current.row - 1][current.column]) {
                        queue.add(new Pair(current.row - 1, current.column));
                    }
                    // check right boundary
                    if (current.row + 1 < grid.length && Integer.parseInt(grid[current.row + 1][current.column] + "") == 1 && !visited[current.row + 1][current.column]) {
                        queue.add(new Pair(current.row + 1, current.column));
                    }
                    // check top boundary
                    if (current.column - 1 >= 0 && Integer.parseInt(grid[current.row][current.column - 1] + "") == 1 && !visited[current.row][current.column - 1]) {
                        queue.add(new Pair(current.row, current.column - 1));
                    }
                    // check bottom boundary
                    if (current.column + 1 < grid[0].length && Integer.parseInt(grid[current.row][current.column + 1] + "") == 1 && !visited[current.row][current.column + 1]) {
                        queue.add(new Pair(current.row, current.column + 1));
                    }
                }
            }
        }

        return countIslands;
    }

    static class Pair {
        public int row;
        public int column;
        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}


