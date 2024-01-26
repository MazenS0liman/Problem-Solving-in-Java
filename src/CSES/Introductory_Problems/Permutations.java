package CSES.Introductory_Problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Accepted

public class Permutations {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());

        if (n == 1) {
            pw.print(1);
        }
        else if (n < 4) {
            pw.println("NO SOLUTION");
        }
        else {
            long even = 2;
            while (even <= n) {
                pw.print(even + " ");
                even += 2;
            }

            long odd = 1;
            while (odd <= n) {
                pw.print(odd + " ");
                odd += 2;
            }
        }

        pw.flush();
    }
}
