package LeetCode.HashTable;
import java.util.*;

public class Substring_with_Concatenation_of_All_Words {

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        ArrayList<Integer> arr = (ArrayList<Integer>) findSubstring(s, words);
        System.out.println(arr);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        // Get the length of each string in the array word
        int len = words[0].length();
        // System.out.println("Length of a word = " + len);

        if (s.length() < len) {
            return new ArrayList<>();
        }
        else {
            Hashtable<String, Integer> hTable = new Hashtable<>();

            for (String word : words) {
                if (hTable.containsKey(word)) {
                    hTable.put(word, hTable.get(word) + 1);
                } else {
                    hTable.put(word, 1);
                }
            }

            ArrayList<Integer> result = new ArrayList<Integer>();
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i - j + 1 == len * words.length) {
                     String s2 = s.substring(j, i + 1);
                     // System.out.println("Substring = " + s2);
                    Hashtable<String, Integer> tmp = new Hashtable<String, Integer>(hTable);
                    boolean found = true;
                    for (int k = j + len; k <= i + 1; k += len) {
                        String v = s.substring(k - len, k);
                        /*
                        System.out.println(v);
                        System.out.println("First Index = " + (k - len));
                        System.out.println("Last Index = " + (k - 1));
                        System.out.println(tmp);
                        */
                        if (tmp.containsKey(v) && tmp.get(v) != 0) {
                            tmp.put(v, tmp.get(v) - 1);
                        }
                        else {
                            found = false;
                            break;
                        }
                    }

                    if (found) {
                        result.add(j);
                    }

                    j++;
                }
            }

            return result;
        }
    }
}
