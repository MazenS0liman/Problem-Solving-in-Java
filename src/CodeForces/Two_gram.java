package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

// Accepted Solution

public class Two_gram {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hmap = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        String str = br.readLine();
        for(int i = 0; i < n - 1; i++) {
            String s = str.substring(i,i+2);
            if (!hmap.containsKey(s)) {
                hmap.put(s, 1);
                arr.add(s);
            }
            else {
                hmap.replace(s, hmap.get(s) + 1);
            }
        }
        int max = 0;
        String letters = "";
        for (String s : arr) {
            int value = hmap.get(s);
            if (value > max) {
                max = value;
                letters = s;
            }
        }
        pw.println(letters);
        pw.flush();

    }
}
