package LeetCode.HashTable;
import java.util.Hashtable;

/*
    Problem: Longest Substring Without Repeating Characters
    URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    Time Complexity: O(n^2)
    Solution: Accepted
*/

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        String s = "asjrgapa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        else {
            Hashtable<String, Integer> hTable = new Hashtable<>();
            int i = 0;
            int j = 0;
            int counter = 0;
            int max = 0;

            while(i < s.length()) {
                String key1 = s.charAt(i) + "";

                if (hTable.containsKey(key1)) {
                    while (j < s.length() && j < i) {
                        String key2 = s.charAt(j) + "";
                        if (key1.equals(key2)) {
                            hTable.put(key2, i);
                            if (counter > max) {
                                max = counter;
                            }
                            j++;
                            i++;
                            break;
                        }
                        else {
                            hTable.remove(key2);
                            counter--;
                            j++;
                        }
                    }
                }
                else {
                    hTable.put(key1, i);
                    counter++;
                    if (counter > max) {
                        max = counter;
                    }
                    i++;
                }
            }

            return max;
        }
    }
}
