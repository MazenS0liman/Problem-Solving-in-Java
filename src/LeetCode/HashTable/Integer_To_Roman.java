package LeetCode.HashTable;

import java.util.*;

public class Integer_To_Roman {

    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        Hashtable<Integer, String> hTable = new Hashtable<>();
        for (int value : values) {
            switch (value) {
                case 1:
                    hTable.put(value, "I");
                    break;
                case 4:
                    hTable.put(value, "IV");
                    break;
                case 5:
                    hTable.put(value, "V");
                    break;
                case 9:
                    hTable.put(value, "IX");
                    break;
                case 10:
                    hTable.put(value, "X");
                    break;
                case 40:
                    hTable.put(value, "XL");
                    break;
                case 50:
                    hTable.put(value, "L");
                    break;
                case 90:
                    hTable.put(value, "XC");
                    break;
                case 100:
                    hTable.put(value, "C");
                    break;
                case 400:
                    hTable.put(value, "CD");
                    break;
                case 500:
                    hTable.put(value, "D");
                    break;
                case 900:
                    hTable.put(value, "CM");
                    break;
                case 1000:
                    hTable.put(value, "M");
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = values.length - 1; i >= 0; i--) {
            if (num == 0) {
                break;
            }
            int count = num / values[i];
            num = num % values[i];
            String key = hTable.get(values[i]);
            while (count > 0) {
                result.append(key);
                count--;
            }
        }

        return result.toString();
    }

    public static String integerToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int[] dp = new int[num + 1];
        int[] min = new int[num + 1];
        Hashtable<Integer, String> hTable = new Hashtable<>();

        for (int value : values) {
            switch (value) {
                case 1:
                    hTable.put(value, "I");
                    break;
                case 4:
                    hTable.put(value, "IV");
                    break;
                case 5:
                    hTable.put(value, "V");
                    break;
                case 9:
                    hTable.put(value, "IX");
                    break;
                case 10:
                    hTable.put(value, "X");
                    break;
                case 40:
                    hTable.put(value, "XL");
                    break;
                case 50:
                    hTable.put(value, "L");
                    break;
                case 90:
                    hTable.put(value, "XC");
                    break;
                case 100:
                    hTable.put(value, "C");
                    break;
                case 400:
                    hTable.put(value, "CD");
                    break;
                case 500:
                    hTable.put(value, "D");
                    break;
                case 900:
                    hTable.put(value, "CM");
                    break;
                case 1000:
                    hTable.put(value, "M");
                    break;
            }
        }

        helperMethod(values, dp, min, num);
        System.out.println("Dp = " + Arrays.toString(dp));

        int i = num;
        StringBuilder str = new StringBuilder();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(i > 0) {
            pq.add(dp[i]);
            i = i - dp[i];
        }

        while(!pq.isEmpty()) {
            int val = pq.poll();
            str.append(hTable.get(val));
        }

        return str.toString();
    }

    public static int helperMethod(int[] values, int[] dp, int[] min, int num) {
        if (num == 0) {
            return 0;
        }
        else if (dp[num] != 0) {
            return min[num];
        }
        else {
            int minimum = Integer.MAX_VALUE;
            int change = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] <= num) {
                    int tmp = helperMethod(values, dp, min, num - values[i]) + 1;

                    if (tmp < minimum) {
                        minimum = tmp;
                        change = values[i];
                    }
                }
            }
            dp[num] = change;
            min[num] = minimum;
            return minimum;
        }
    }
}
