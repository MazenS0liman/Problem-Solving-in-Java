package CSES.Introductory_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// TLE

public class Repetitions {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String str = br.readLine();
        String tmp = str.charAt(0) + "";
        int length = 1;
        int max = 1;

        for (int i = 1; i < str.length(); i++) { // O(n)
            if (length == 0 || tmp.charAt(0) == str.charAt(i)) {
                tmp += str.charAt(i);
                length++;

                if (length > max) {
                    max = length;
                }
            }
            else {
                tmp = str.charAt(i) + "";
                length = 1;
            }
        }

        pw.print(max);
        pw.flush();
    }
}

