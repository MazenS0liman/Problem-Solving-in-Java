package CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

// Accepted Solution

public class Misha_and_Changing_Handles {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> uniqueNames = new ArrayList<String>();
        HashMap<String, String> hmap = new HashMap<String, String>();
        HashMap<String, String> current = new HashMap<String, String>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            if (!hmap.containsKey(str[0]) && (!current.containsKey(str[0]) || current.get(str[0]) == null)) {
                uniqueNames.add(str[0]);
                hmap.put(str[0], str[1]);
                current.put(str[1], str[0]);
            }
            else {
                if (current.containsKey(str[0]) && current.get(str[0]) != null) {
                    String key = current.get(str[0]);
                    hmap.replace(key, str[1]);
                    current.replace(str[0], null);
                    current.put(str[1], key);
                }
            }
        }

        pw.println(uniqueNames.size());
        for (String key: uniqueNames) {
            pw.println(key + " " + hmap.get(key));
        }

        pw.flush();
    }
}
