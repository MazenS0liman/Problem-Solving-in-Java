package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Accepted Solution
public class Regular_Bracket_Sequence {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] arr = br.readLine().split("");
        int count = 0;
        int openingBracket = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                openingBracket++;
            }
            if (arr[i].equals(")") && openingBracket > 0) {
                openingBracket--;
                count += 2;
            }
        }

        pw.print(count);
        pw.flush();
    }



}
