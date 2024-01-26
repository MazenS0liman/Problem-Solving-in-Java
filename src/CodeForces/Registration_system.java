package CodeForces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

// Accepted Solution
public class Registration_system {
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hm  = new HashMap<>(n);

        ArrayList<String> arr1 = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr1.add(br.readLine());
        }

        for (String s : arr1) {
            if(!hm.containsKey(s)) {
                hm.put(s,1);
                pw.println("OK");
            }
            else {
                int t = hm.get(s);
                pw.println(s + t);
                hm.put(s, t + 1);

            }
        }
        pw.flush();
    }

}
