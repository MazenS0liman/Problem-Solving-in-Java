package CSES.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Accepted

public class Distinct_Numbers {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer str = new StringTokenizer(br.readLine());
        int count = 0;
        Long prev = null;

        for (int i = 0; i < arr.length; i++) {
            if (str.hasMoreTokens()) {
                arr[i] = Long.parseLong(str.nextToken());
            }
        }

        sort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            if (prev == null || prev != arr[i]) {
                prev = arr[i];
                count++;
            }
        }

        pw.println(count);
        pw.flush();
    }

    public static void sort (long[] arr, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort (arr, mid + 1, right);
            merge (arr, left, mid, right);
        }
    }

    public static void merge (long[] arr, int left, int mid, int right) {
        long[] tmp = new long[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] == arr[j]) {
                tmp[k++] = arr[i++];
                tmp[k++] = arr[j++];
            }
            else if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            }
            else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int m = 0; m < tmp.length; m++) {
            arr[left++] = tmp[m];
        }
    }

}
