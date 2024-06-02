package LeetCode.Backtracking;

/*
    ----------------------------------------------------------------
    | Problem: Word Search
    | Link: https://leetcode.com/problems/word-search
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Word_Search {

    public boolean exist(char[][] board, String word) {
        char firstChar = word.charAt(0);
        boolean[][] visited;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    boolean result = search(i - 1, j, 1, visited, board, word)
                            || search(i + 1, j, 1, visited, board, word)
                            || search(i, j - 1, 1, visited, board, word)
                            || search(i, j + 1, 1, visited, board, word);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    public boolean search(int i, int j, int index, boolean[][] visited, char[][] board, String word) {
        if (index >= word.length()) {
            return true;
        }
        else if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        else {
            visited[i][j] = true;
            boolean result = search(i - 1, j, index + 1, visited, board, word)
                    || search(i + 1, j, index + 1, visited, board, word)
                    || search(i, j - 1, index + 1, visited, board, word)
                    || search(i, j + 1, index + 1, visited, board, word);

            visited[i][j] = result;
            return result;
        }
    }
}
