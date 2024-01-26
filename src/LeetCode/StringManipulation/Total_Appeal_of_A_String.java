package LeetCode.StringManipulation;

import java.util.Arrays;
import java.util.HashSet;

public class Total_Appeal_of_A_String {

    public static void main(String[] args) {
        Total_Appeal_of_A_String a = new Total_Appeal_of_A_String();
        System.out.println(a.appealSum("abbca"));
    }

    public long appealSum(String s) {
        int len = s.length();
        HashSet<Character>[] dp = new HashSet[len];
        int[] counts = new int[len];
        int counter = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(s.charAt(i));
            counts[i] = 1;
            counter += 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!dp[j].contains(s.charAt(j - i))) {
                    dp[j].add(s.charAt(j - i));
                    counts[j] += 1;
                }

                counter += counts[j];
            }
        }

        return counter;
    }

    public long appealSum2D(String s) {
        long counter = 0;
        HashSet<Character>[][] dp = new HashSet[s.length()][s.length()];

        int j = 0;
        while(j < s.length()) {
            int i = 0;
            int k = j;
            while(k < s.length()) {
                if (i == k) {
                    dp[i][k] = new HashSet<>();
                    dp[i][k].add(s.charAt(i));
                    counter++;
                }
                else {
                    if (dp[i + 1][k].contains(s.charAt(i))) {
                        dp[i][k] = dp[i + 1][k];
                        counter += dp[i][k].size();
                    }
                    else {
                        dp[i][k] = dp[i + 1][k];
                        dp[i][k].add(s.charAt(i));
                        counter += dp[i][k].size();
                    }
                }

                i++;
                k++;
            }

            j++;
        }

        return counter;
    }
}
