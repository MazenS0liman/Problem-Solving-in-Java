//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
//    public static void main(String[]args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        PrintWriter pw = new PrintWriter(System.out);
//        String[] words = new String[n+1];
//
//        for (int i = 0; i < n; i++) {
//            String[] line = br.readLine().split(" ");
//            words[Integer.parseInt(line[1])] = line[0];
//        }
//
//        int t = Integer.parseInt(br.readLine());
//        for(int i = 0; i < t; i++) {
//            String str = br.readLine();
//            Stack<String> stack = new Stack<>();
//            for (String s : words) {
//                if (s == null) continue;
//                if (s.startsWith(str)) {
//                    stack.add(s);
//                }
//                if (stack.size() == 2) {
//                    break;
//                }
//            }
//
//            if (stack.isEmpty()) {
//                pw.println(-1);
//            }
//            else {
//                pw.println(stack.pop());
//            }
//        }
//        pw.flush();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s1 = br.readLine();
        int k = Integer.parseInt(br.readLine());
        String s2 = br.readLine();
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();

        if (s1.length() % k != 0 || s2.length() % k != 0 || s1.length() != s2.length()) {
            pw.println(0);
        }
        else {
            int mod = s1.length() % k;
            for (int i = 0; i < mod; i += k) {
                String tmp = s1.substring(i, i + k);
                if (hMap.containsKey(tmp)) {
                    hMap.put(tmp, hMap.get(tmp) + 1);
                }
                else {
                    hMap.put(tmp, 1);
                }
            }

            boolean flag = true;
            for (int i = 0; i < mod; i += k) {
                String tmp = s2.substring(i, i + k);
                if (hMap.containsKey(tmp) && hMap.get(tmp) > 0) {
                    hMap.put(tmp, hMap.get(tmp) - 1);
                }
                else {
                    flag = false;
                }
            }

            if (flag) {
                pw.println(1);
            }
            else {
                pw.println(0);
            }
        }

        pw.flush();
    }
}
