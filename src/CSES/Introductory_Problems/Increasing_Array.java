package CSES.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Accepted

public class Increasing_Array {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n  = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        long count = 0;
        long prev = 0;

        if (str.hasMoreTokens()) {
            prev = Long.parseLong(str.nextToken());
        }

        while (str.hasMoreTokens()) {
            long current = Long.parseLong(str.nextToken());
            if (current < prev) {
                count += (prev - current);
            }
            else {
                prev = current;
            }
        }

        pw.print(count);
        pw.flush();
    }
}
