package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/*
    ----------------------------------------------------------------
    | Problem: Group Anagrams
    | Link: https://leetcode.com/problems/group-anagrams
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Group_Anagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> ht = new Hashtable<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            List<Character> characters = new ArrayList<>();
            int length = strs[i].length();
            String str = strs[i];

            for (int j = 0; j < length; j++) {
                characters.add(str.charAt(j));
            }

            Collections.sort(characters);

            StringBuilder key = new StringBuilder();
            for (Character c : characters) {
                key.append(c);
            }

            if (ht.containsKey(key.toString())) {
                ht.get(key.toString()).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                ht.put(key.toString(), list);
            }

        }

        List<List<String>> result = new ArrayList<>();
        for (String key : ht.keySet()) {
            result.add(ht.get(key));
        }

        return result;
    }
}
