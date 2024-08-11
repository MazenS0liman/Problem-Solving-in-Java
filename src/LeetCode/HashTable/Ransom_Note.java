package LeetCode.HashTable;

import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Ransom Note
    | Link: https://leetcode.com/problems/ransom-note
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character, Integer> hTable = new Hashtable<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (hTable.containsKey(magazine.charAt(i))) {
                hTable.put(magazine.charAt(i), hTable.get(magazine.charAt(i)) + 1);
            }
            else {
                hTable.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!hTable.containsKey(ransomNote.charAt(i)) || hTable.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            else {
                hTable.put(ransomNote.charAt(i), hTable.get(ransomNote.charAt(i)) - 1);
            }
        }

        return true;
    }
}
