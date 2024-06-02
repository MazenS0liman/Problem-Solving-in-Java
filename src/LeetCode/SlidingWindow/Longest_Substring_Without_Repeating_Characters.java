package LeetCode.SlidingWindow;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Longest Substring Without Repeating Characters
    | Link: https://leetcode.com/problems/longest-substring-without-repeating-characters
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hSet = new HashSet<>();
        int currentLength = 0;
        int maxLength = 0;
        int length = s.length();
        int leftPointer = 0;

        for (int i = 0; i < length; i++) { // O(n)

            if (hSet.contains(s.charAt(i))) {
                while(hSet.contains(s.charAt(i))) { // O(1)
                    hSet.remove(s.charAt(leftPointer));
                    leftPointer++;
                }

                hSet.add(s.charAt(i));
                currentLength = i - leftPointer + 1;
            }
            else {
                hSet.add(s.charAt(i));
                currentLength++;

                if (currentLength > maxLength) maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
