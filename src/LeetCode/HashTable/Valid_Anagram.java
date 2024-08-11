package LeetCode.HashTable;

import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Valid Anagram
    | Link: https://leetcode.com/problems/valid-anagram
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        Hashtable<Character, Integer> hTable = new Hashtable<>();
        int count = 0;

        for (int i = 0; i < sLength; i++) {
            if (hTable.containsKey(s.charAt(i))) {
                hTable.put(s.charAt(i), hTable.get(s.charAt(i)) + 1);
            }
            else {
                hTable.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < tLength; i++) {
            if ((!hTable.containsKey(t.charAt(i))) || hTable.get(t.charAt(i)) == 0) return false;
            else {
                hTable.put(t.charAt(i), hTable.get(t.charAt(i)) - 1);
            }
        }

        return true;
    }
}
