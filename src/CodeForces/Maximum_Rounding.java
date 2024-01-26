package CodeForces;

/*
    ----------------------------------------------------------------
    | Link: https://codeforces.com/contest/1857/problem/B
    | Status: TLE
    ----------------------------------------------------------------
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Maximum_Rounding {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int test = Integer.parseInt(br.readLine());
        for (int a = 0; a < test; a++) {
            String value = br.readLine();
            int k = -1;
            int carry = 0;
            String result = "";
            String zeros = "";
            String tmp = "";

            for (int i = value.length() - 1, j = 0; i >= 0; i--, j++) {
                int digit = Integer.parseInt(value.charAt(i) + "");

                if (carry == 1) {
                    digit++;
                    carry = 0;
                }

                if (digit >= 5) {
                    k = j;
                    carry = 1;
                }

                tmp = digit + tmp;
                zeros += "0";
            }

            k++;
            result = tmp.substring(0, value.length() - k) + zeros.substring(0, k);

            if (carry == 1) {
                result = "1" + result;
            }

            pw.println(result);
        }
        pw.flush();
    }
}
