package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Great_Vova_Wall_1 {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer in = new StringTokenizer(str);
        boolean evenDiff = false;
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        while(in.hasMoreTokens()) {
            int value = Integer.parseInt(in.nextToken());
            stack.push(value);
            if (value > max) {
                max =value;
            }
        }

        boolean first = false;
        boolean second = false;

        while (true) {
            int value = stack.pop();
            Stack<Integer> tmp = new Stack<>();

            if (!tmp.isEmpty()) {
                if (tmp.peek() == value && value < max) {
                    tmp.push(tmp.pop() + 1);
                    tmp.push(value + 1);
                }
                else {
                    tmp.push(tmp.pop() + 2);
                    if (tmp.peek() > max) {
                        max = tmp.peek();
                        if (!first) {
                            first = true;
                        }
                        else {
                            second = true;
                            break;
                        }
                    }
                    tmp.push(value);
                }
            }
            else {
                tmp.push(value);
            }
            boolean same = true;

            while (!tmp.isEmpty()) {
                if (tmp.peek() != max) {
                    same = false;
                }
                stack.push(tmp.pop());
            }

            if (same) {
                break;
            }
        }
    }
}
