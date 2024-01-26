package CSES.Introductory_Problems;

// Link: https://cses.fi/problemset/task/1092
// Accepted

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Two_Sets {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());
        long sum = 0;

        // list 1
        ArrayList<Long> arr1 = new ArrayList<>();
        long s1 = 0;

        // list 2
        ArrayList<Long> arr2 = new ArrayList<>();
        long s2 = 0;

        for (long i = 1; i <= n; i++) {
            sum += i;
        }

        if (sum % 2 == 0) {
            pw.println("YES");
            for (long i = n; i >= 1; i--) {
                if (s1 + i <= sum / 2) {
                    s1 += i;
                    arr1.add(i);
                }
                else {
                    s2 += i;
                    arr2.add(i);
                }
            }

            pw.println(arr1.size());
            for (long i : arr1) {
                pw.print(i + " ");
            }
            pw.println();
            pw.println(arr2.size());
            for (long i : arr2) {
                pw.print(i + " ");
            }
        }
        else {
            pw.println("NO");
        }

        pw.flush();
    }
}
