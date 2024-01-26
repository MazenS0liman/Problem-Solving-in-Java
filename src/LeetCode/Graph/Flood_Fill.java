package LeetCode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 0;
        floodFill(image, sr, sc, color);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // base case
        if (image[sr][sc] == color) {
            return image;
        }
        else {
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(sr, sc));
            int originalColor = image[sr][sc];
            while(!queue.isEmpty()) {
                Pair current = queue.poll();
                image[current.row][current.column] = color;
                // check the left boundary
                if (current.row - 1 >= 0 && image[current.row - 1][current.column] == originalColor) {
                    queue.add(new Pair(current.row - 1, current.column));
                }
                // check the right boundary
                if (current.row + 1 < image.length && image[current.row + 1][current.column] == originalColor) {
                    queue.add(new Pair(current.row + 1, current.column));
                }
                // check the top boundary
                if (current.column - 1 >= 0 && image[current.row][current.column - 1] == originalColor) {
                    queue.add(new Pair(current.row, current.column - 1));
                }
                // check the bottom boundary
                if (current.column + 1 < image[0].length && image[current.row][current.column + 1] == originalColor) {
                    queue.add(new Pair(current.row, current.column + 1));
                }
            }

            return image;
        }
    }
}

class Pair {
    public int row;
    public int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}