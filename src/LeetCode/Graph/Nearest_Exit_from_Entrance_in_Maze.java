package LeetCode.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
    ----------------------------------------------------------------
    | Problem: Nearest Exit from Entrance in Maze
    | Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Nearest_Exit_from_Entrance_in_Maze {

    public static void main(String[] args) {
        char[][] maze = {{'+'},
                        {'.'}};
        int[] entrance = {1,0};

        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(entrance[0], entrance[1], 0));

        int rowLength = maze.length;
        int columnLength = maze[0].length;

        boolean[][] visited = new boolean[rowLength][columnLength];
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int count = pair.level;

            if ((pair.i == 0 || pair.i == rowLength - 1 || pair.j == 0 || pair.j == columnLength - 1) && !(pair.i == entrance[0] && pair.j == entrance[1])) {
                return count;
            }

            if (pair.i - 1 >= 0 && !visited[pair.i - 1][pair.j] && maze[pair.i - 1][pair.j] == '.') {
                queue.add(new Pair(pair.i - 1, pair.j, count+1));
                visited[pair.i - 1][pair.j] = true;
            }

            if (pair.i + 1 < rowLength && !visited[pair.i + 1][pair.j] && maze[pair.i + 1][pair.j] == '.' ) {
                queue.add(new Pair(pair.i + 1, pair.j, count+1));
                visited[pair.i + 1][pair.j] = true;
            }

            if (pair.j + 1 < columnLength && !visited[pair.i][pair.j + 1] && maze[pair.i][pair.j + 1] == '.') {
                queue.add(new Pair(pair.i, pair.j + 1, count+1));
                visited[pair.i][pair.j + 1] = true;
            }

            if (pair.j - 1 >= 0 && !visited[pair.i][pair.j - 1] && maze[pair.i][pair.j - 1] == '.') {
                queue.add(new Pair(pair.i, pair.j - 1, count+1));
                visited[pair.i][pair.j - 1] = true;
            }
        }

        return -1;
    }

    static class Pair {
        int i;
        int j;
        int level;

        Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
}
