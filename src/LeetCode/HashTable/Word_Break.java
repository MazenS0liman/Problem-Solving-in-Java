package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break {

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(str, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        int index = s.length() - 1;

        while(index >= 0) {
            for (int i = 0; i < wordDict.size() && index + wordDict.get(i).length() <= s.length(); i++) {
                String substr = s.substring(index, index + wordDict.get(i).length());
                dp[index] = substr.equals(wordDict.get(i)) && dp[index + wordDict.get(i).length()];
                System.out.println("substring: " + substr);
            }

            index--;
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return dp[0];
    }
}
