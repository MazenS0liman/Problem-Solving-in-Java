package LeetCode.SlidingWindow;
import java.util.*;

/*
    ----------------------------------------------------------------
    | Problem: Palindrome Partitioning
    | Link: https://leetcode.com/problems/palindrome-partitioning
    | Status: Accepted
    ----------------------------------------------------------------
*/

public class Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        return partitionHelper(new ArrayList<>(), s, 0, 1);
    }

    public List<List<String>> partitionHelper(List<String> list, String s, int startIndex, int endIndex) {
        List<List<String>> output = new ArrayList<>();

        if (endIndex == s.length()) {
            if (startIndex < endIndex) {
                list.add(s.substring(startIndex, endIndex));
            }

            boolean flag = true;

            for (String str : list) {
                if (!isPalindrome(str)) {
                    flag = false;
                }
            }

            if (flag) {
                output.add(list);
            }
            return output;
        }
        else {
            List<String> l1 = new ArrayList<>(list);
            List<String> l2 = new ArrayList<>(list);
            l2.add(s.substring(startIndex, endIndex));
            List<List<String>> left = partitionHelper(l1, s, startIndex, endIndex + 1);
            List<List<String>> right = partitionHelper(l2, s, endIndex, endIndex + 1);

            output.addAll(left);
            output.addAll(right);
        }

        return output;
    }

    public boolean isPalindrome(String s) { // O(n)
        if (s.length() == 1 || s.isEmpty()) {
            return true;
        }
        else if (s.charAt(s.length() - 1) == s.charAt(0)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        else {
            return false;
        }
    }
}
