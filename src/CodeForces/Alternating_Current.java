package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/*Steps:
    1. Traverse the string from left to right.
    2. And for every sign in the string:
    1. Look whether the top of the stack has the same sign as the current sign in the string.
    2. if yes → pop once from the stack
    3. if no → push into the stack*/
public class Alternating_Current {
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String in = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < in.length(); i++) {
            boolean push = true;
            if (!stack.isEmpty()) {
                if (in.charAt(i) == stack.peek()) {
                    stack.pop();
                    push = false;
                }
            }
            if (push) {
                stack.push(in.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            pw.print("Yes");
        }
        else {
            pw.print("No");
        }
        pw.flush();
    }
}
