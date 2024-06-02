package LeetCode.DynamicProgramming;

/*
    ----------------------------------------------------------------
    | Problem: Longest Palindromic Substring
    | Link: https://leetcode.com/problems/longest-palindromic-substring
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String longestPalindrome = "";

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == 0) dp[i][j] = true;
                else if (s.charAt(j) == s.charAt(j - i)) dp[i][j] = i == 1 || dp[i - 2][j - 1];
                else dp[i][j] = false;

                if (dp[i][j]) longestPalindrome = s.substring(j - i, j + 1);
            }
        }

        return longestPalindrome;
    }
}
