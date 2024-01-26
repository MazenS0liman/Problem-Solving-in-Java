package CSES.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// Accepted

public class Missing_Number {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        while (str.hasMoreTokens()) {
            arr[Integer.parseInt(str.nextToken())] = true;
        }

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                pw.print(i);
            }
        }

        pw.flush();
    }


}
