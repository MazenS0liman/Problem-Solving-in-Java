package CodeForces;

/*
    ----------------------------------------------------------------
    | Link: https://codeforces.com/contest/1857/problem/A
    | Status: Accepted
    ----------------------------------------------------------------
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Array_Coloring {
    /* Note:
       - Odd + Odd = Even
       - Even + Even = Even
       - Odd + Even = Odd
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long t = Long.parseLong(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer str = new StringTokenizer(br.readLine());
            long countEven = 0;
            long countOdd = 0;

            while (str.hasMoreTokens()) {
                long var = Long.parseLong(str.nextToken());
                if (var % 2 == 0) {
                    countEven++;
                }
                else {
                    countOdd++;
                }
            }

            if (countOdd % 2 == 0) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }
        }
        pw.flush();
    }
}
