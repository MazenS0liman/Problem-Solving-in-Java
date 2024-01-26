package CSES.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Link:
//

public class Bit_Strings {

    static long mod = 1000000007;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine());
        long result = 1;

        for (long i = 0; i < n; i++) {
            result *= 2;
            result %= mod;
        }

        pw.print(result);
        pw.flush();
    }
}
