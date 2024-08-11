package LeetCode.HashTable;

import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Isomorphic Strings
    | Link: https://leetcode.com/problems/isomorphic-strings
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        else {
            Hashtable<Character, Character> sTable = new Hashtable<>();
            Hashtable<Character, Character> tTable = new Hashtable<>();

            for (int i = 0; i < s.length(); i++) {
                if (sTable.containsKey(s.charAt(i))) {
                    if (!tTable.containsKey(t.charAt(i))) {
                        return false;
                    }
                    else {
                        Character smappedCharacter = sTable.get(s.charAt(i));
                        Character tmappedCharacter = tTable.get(t.charAt(i));

                        if (smappedCharacter != t.charAt(i) || tmappedCharacter != s.charAt(i)) {
                            return false;
                        }
                    }
                }
                else {
                    if (tTable.containsKey(t.charAt(i))) {
                        return false;
                    }
                    else {
                        sTable.put(s.charAt(i), t.charAt(i));
                        tTable.put(t.charAt(i), s.charAt(i));
                    }
                }
            }

            return true;
        }
    }
}
