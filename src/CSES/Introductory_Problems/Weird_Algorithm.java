package CSES.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Accepted

public class Weird_Algorithm {

    // Even -> n / 2
    // Odd -> n * 3 + 1

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Integer.parseInt(br.readLine());
        pw.print(n + " ");

        while (n != 1) {
            if (n % 2 == 0) { // n is even
                n = n / 2;
            }
            else { // n is odd
                n = n * 3 + 1;
            }

            pw.print(n + " ");
        }

        pw.flush();
    }

}

