package CSES.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Accepted

public class Apartments {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken()); // the number of applicants
        int m = Integer.parseInt(token.nextToken()); // the number of apartments
        long k = Integer.parseInt(token.nextToken()); // the maximum allowed difference
        int count = 0;

        StringTokenizer line1 = new StringTokenizer(br.readLine());
        StringTokenizer line2 = new StringTokenizer(br.readLine());

        long[] arr1 = new long[n];
        long[] arr2 = new long[m];

        for (int i = 0; i < arr1.length; i++) { // O(n)
            arr1[i] = Long.parseLong(line1.nextToken());
        }

        for (int i = 0; i < arr2.length; i++) { // O(m)
            arr2[i] = Long.parseLong(line2.nextToken());
        }

        sort(arr1, 0, arr1.length - 1); // O(n * log n)
        sort(arr2, 0, arr2.length - 1); // O(m * log m)

        int i = 0;
        int j = 0;
        for (;i < arr1.length; i++) {
            for (;j < arr2.length;) {

                if (arr2[j] > arr1[i] + k) {
                    break;
                }

                if (arr2[j] <= arr1[i] + k && arr2[j] >= arr1[i] - k) {
                    count++;
                    j++;
                    break;
                }
                else {
                    j++;
                }
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
