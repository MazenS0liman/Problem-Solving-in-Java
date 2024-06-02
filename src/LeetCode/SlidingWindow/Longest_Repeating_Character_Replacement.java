package LeetCode.SlidingWindow;

import java.util.Arrays;
import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Longest Repeating Character Replacement
    | Link: https://leetcode.com/problems/longest-repeating-character-replacement
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Longest_Repeating_Character_Replacement {
    public static void main(String[]args) {
        System.out.println(characterReplacement("ABCCCCC", 2));
    }

    public static int characterReplacement(String s, int k) {
        int length = s.length();
        int leftPointer = 0;
        int rightPointer = 0;
        int longestSubstring = 0;
        Hashtable<Character, Integer> hTable = new Hashtable<>();

        while(rightPointer < length) {
            int numOfCharacters = rightPointer - leftPointer + 1;
            int numOfFrequentCharacter = 0;

            if (hTable.containsKey(s.charAt(rightPointer))) {
                hTable.put(s.charAt(rightPointer), hTable.get(s.charAt(rightPointer)) + 1);
            }
            else {
                hTable.put(s.charAt(rightPointer), 1);
            }

            for (Character c : hTable.keySet()) {
                int count = hTable.get(c);
                if (count > numOfFrequentCharacter) {
                    numOfFrequentCharacter = count;
                }
            }

            int numOfCharacterToReplace = numOfCharacters - numOfFrequentCharacter;

            if (numOfCharacterToReplace > k) {
                hTable.put(s.charAt(leftPointer), hTable.get(s.charAt(leftPointer)) - 1);
                if (rightPointer != leftPointer) hTable.put(s.charAt(rightPointer), hTable.get(s.charAt(rightPointer)) - 1);
                leftPointer++;
            }
            else {
                if (numOfCharacters > longestSubstring) {
                    longestSubstring = numOfCharacters;
                }

                rightPointer++;
            }
        }

        return longestSubstring;
    }
}
