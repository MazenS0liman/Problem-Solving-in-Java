package CSES.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
Time Complexity: n <= 1000 -> O(n^2)
Input:
    height: n
    width: m
    floor: .
    wall: #
Output:
    the number of rooms
*/

// TLE


public class Problem_1_Counting_Rooms {
    public static String[][] map;
    public static boolean[][] visited;
    public static int count = 0;
    public static int rows;
    public static int columns;

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] size = br.readLine().split(" ");
        rows = Integer.parseInt(size[0]);
        columns = Integer.parseInt(size[1]);
        map = new String[rows][columns];
        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < columns; j++)
            {
                map[i][j] = "" + str.charAt(j);
                if (str.charAt(j) == '.') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (map[i][j].equals(".") && visited[i][j])
                {
                    count++;
                    visitedNext(i, j);
                }
            }

        }

        pw.println(count);
        pw.flush();
    }

    public static void visitedNext(int i, int j) {
        visited[i][j] = false;
        if (j + 1 < columns && visited[i][j + 1]) {
            visitedNext(i, j + 1);
        }
        if (i + 1 < rows && visited[i + 1][j]) {
            visitedNext(i + 1, j);
        }
        if (j - 1 > -1 && visited[i][j - 1]) {
            visitedNext(i, j - 1);
        }
        if (i - 1 > -1 && visited[i - 1][j]) {
            visitedNext(i - 1, j);
        }
    }

    public static void print(boolean[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }
}
