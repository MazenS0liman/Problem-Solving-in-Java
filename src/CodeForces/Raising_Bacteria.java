package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// Accepted Solution

public class Raising_Bacteria {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long n = Long.parseLong(reader.readLine());
        if (n == 0) {
            pw.println(0);
        }
        else {
            long added = 0;
            while (n > 0) {
                if (n % 2 != 0) {
                    added += 1;
                }
                n /= 2;
            }
            pw.println(added);
        }

        pw.flush();
    }


}
