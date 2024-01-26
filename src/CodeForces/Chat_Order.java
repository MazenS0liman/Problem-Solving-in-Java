package CodeForces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

// Accepted Solution

public class Chat_Order {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        Stack<String> chat = new Stack<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            chat.push(s);
        }

        while(!chat.isEmpty()) {
            if(!hmap.containsKey(chat.peek())) {
                hmap.put(chat.peek(),0);
                stack.push(chat.pop());
            }
            else {
                chat.pop();
            }
        }

        while(!stack.isEmpty()) {
            chat.push(stack.pop());
        }

        while(!chat.isEmpty()) {
            pw.println(chat.pop());
        }

        pw.flush();
    }

}
