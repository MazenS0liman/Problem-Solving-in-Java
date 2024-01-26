package CSES.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// TLE

public class Ferris_Wheel {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken()); // the number of children
        long x = Long.parseLong(str.nextToken()); // the maximum allowed weight
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        long[] tmp = new long[n];
        long[] num = new long[n];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            tmp[i] = x;
            num[i] = 2;
        }

        sort(arr, 0, arr.length - 1);

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] - arr[i] >= 0 && num[j] > 0) {
                    tmp[j] = tmp[j] - arr[i];
                    num[j]--;
                    break;
                }
            }
        }

        for (int j = 0; j < tmp.length; j++) {
            if (tmp[j] != x) {
                count++;
            }
            else {
                break;
            }
        }


//        System.out.println("arr: ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        System.out.println("tmp: ");
//        for (int i = 0; i < tmp.length; i++) {
//            System.out.print(tmp[i] + " ");
//        }
//        System.out.println();

        pw.print(count);
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
