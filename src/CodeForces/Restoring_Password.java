package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

// Accepted Solution

public class Restoring_Password {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        String binaryCode = br.readLine();
        for (int i = 0; i < 10; i++) {
            hmap.put(br.readLine(), i);
        }

        String str = "";
        for(int i = 0; i < binaryCode.length(); i++) {
            str = str + binaryCode.charAt(i);
            if (str.length() % 10 == 0) {
                pw.print(hmap.get(str));
                str = "";
            }
        }
        pw.flush();
    }
}
