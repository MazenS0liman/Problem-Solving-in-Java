package LeetCode.SlidingWindow;

import java.util.HashSet;

/*
    ----------------------------------------------------------------
    | Problem: Maximum Number of Vowels in a Substring of Given Length
    | Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
    | Status: Solution Accepted
    ----------------------------------------------------------------
*/
public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

    public static void main(String[] args) {


    }

    public int maxVowels(String s, int k) {
        HashSet<Character> hSet = new HashSet<>();
        hSet.add('a');
        hSet.add('e');
        hSet.add('i');
        hSet.add('o');
        hSet.add('u');

        int len = s.length();
        int front = 0, back = 0;
        int maxAlpha = 0;
        int currentAlpha = 0;

        while (front < len) {
            if (hSet.contains(s.charAt(front))) {
                currentAlpha++;
            }

            if (front - back == k - 1) {
                if (currentAlpha > maxAlpha) {
                    maxAlpha = currentAlpha;
                }
                if (hSet.contains(s.charAt(back))) {
                    currentAlpha--;
                }
                back++;
            }

            front++;
        }

        return maxAlpha;
    }
}
