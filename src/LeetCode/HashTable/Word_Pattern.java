package LeetCode.HashTable;

import java.util.Hashtable;
import java.util.Objects;

/*
    ----------------------------------------------------------------
    | Problem: Word Pattern
    | Link: https://leetcode.com/problems/word-pattern
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Word_Pattern {

    public boolean wordPattern(String pattern, String s) {
        Hashtable<Character, String> hTable1 = new Hashtable<>();
        Hashtable<String, Character> hTable2 = new Hashtable<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (hTable1.containsKey(pattern.charAt(i))) {
                if (hTable2.containsKey(words[i])) {
                       if (!(Objects.equals(hTable1.get(pattern.charAt(i)), words[i]) && hTable2.get(words[i]) == pattern.charAt(i))) {
                           return false;
                       }
                }
                else {
                    return false;
                }
            }
            else {
                if (hTable2.containsKey(words[i])) {
                    return false;
                }
                else {
                    hTable1.put(pattern.charAt(i), words[i]);
                    hTable2.put(words[i], pattern.charAt(i));
                }
            }
        }

        return true;
    }
}
