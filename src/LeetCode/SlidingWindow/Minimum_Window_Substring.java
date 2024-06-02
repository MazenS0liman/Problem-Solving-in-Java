package LeetCode.SlidingWindow;

/*
    ----------------------------------------------------------------
    | Problem: Minimum Window Substring
    | Link: https://leetcode.com/problems/minimum-window-substring
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

import java.util.Hashtable;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int leftPointer = 0;
        int rightPointer = 0;
        int sLength = s.length();
        int tLength = t.length();
        int numberOfCharsNeeded = 0;
        int numberOfCharsHave = 0;
        String result = "";
        Hashtable<Character, Integer> tHashtable = new Hashtable<>();
        Hashtable<Character, Integer> sHashtable = new Hashtable<>();

        for (int i = 0; i < tLength; i++) {
            if (tHashtable.containsKey(t.charAt(i))) {
                tHashtable.put(t.charAt(i), tHashtable.get(t.charAt(i)) + 1);
                numberOfCharsNeeded++;
            }
            else {
                tHashtable.put(t.charAt(i), 1);
                sHashtable.put(t.charAt(i), 0);
                numberOfCharsNeeded++;
            }
        }

        while (rightPointer < sLength) {
            Character c = s.charAt(rightPointer);
            if (sHashtable.containsKey(c) && sHashtable.get(c) < tHashtable.get(c)) {
                sHashtable.put(c, sHashtable.get(c) + 1);
                numberOfCharsHave++;
            }
            else if (sHashtable.containsKey(c)) {
                sHashtable.put(c, sHashtable.get(c) + 1);
            }

            while (numberOfCharsHave == numberOfCharsNeeded) {
                if (!sHashtable.containsKey(s.charAt(leftPointer))) {
                    leftPointer++;
                }
                else if (sHashtable.get(s.charAt(leftPointer)) > tHashtable.get(s.charAt(leftPointer))) {
                    sHashtable.put(s.charAt(leftPointer), sHashtable.get(s.charAt(leftPointer)) - 1);
                    leftPointer++;
                }
                else {
                    break;
                }
            }

            if  (numberOfCharsHave == numberOfCharsNeeded && (rightPointer - leftPointer + 1 < result.length() || result.isEmpty())) {
                result = s.substring(leftPointer, rightPointer + 1);
            }

            rightPointer++;
        }

        return result;
    }
}
