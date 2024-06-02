package LeetCode.DynamicProgramming;

/*
    ----------------------------------------------------------------
    | Problem: Longest Repeating Character Replacement
    | Link: https://leetcode.com/problems/longest-repeating-character-replacement
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int countPalindrome = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == 0) dp[i][j] = true;
                else if (s.charAt(j) == s.charAt(j - i)) dp[i][j] = i == 1 || dp[i - 2][j - 1];
                else dp[i][j] = false;

                if (dp[i][j]) countPalindrome++;
            }
        }

        return countPalindrome;
    }
}
