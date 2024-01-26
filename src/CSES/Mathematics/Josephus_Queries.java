package CSES.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// TLE

public class Josephus_Queries {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(str.nextToken());
            int nth  = Integer.parseInt(str.nextToken());

            boolean[] arr = new boolean[size];
            int current = 0;

            for (int j = 0; j < arr.length; j = (j + 1) % arr.length) {
                if (!arr[j]) { // found first
                    j = (j + 1) % arr.length;
                    for (;j < arr.length; j = (j + 1) % arr.length) {
                        if (!arr[j]) { // found second
                            arr[j] = true;
                            nth--;
                            break;
                        }
                    }
                }
                if (nth == 0) {
                    pw.println(j + 1);
                    break;
                }
            }
        }

        pw.flush();
    }
}
