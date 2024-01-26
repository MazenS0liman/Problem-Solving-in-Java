package CSES.Introductory_Problems;

// Link: https://cses.fi/problemset/task/1618
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Trailing_Zeros {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i % 5 == 0) {
                count++;
            }
        }

        pw.print(count);
        pw.flush();
    }
}
