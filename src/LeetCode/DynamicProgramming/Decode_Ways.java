package LeetCode.DynamicProgramming;

import java.util.Stack;

/*
    ----------------------------------------------------------------
    | Problem: Valid Parentheses
    | Link: https://leetcode.com/problems/valid-parentheses
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Decode_Ways {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() != '(') return false;
            else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() != '{') return false;
            else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() != '[') return false;
            else if ((s.charAt(i) == ')'|| s.charAt(i) == ']' || s.charAt(i) == '}')&& stack.isEmpty()) return false;
            else stack.pop();
        }

        return stack.isEmpty();
    }
}
