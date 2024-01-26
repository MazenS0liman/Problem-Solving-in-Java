package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

// Time Limit Exceeded

public class Productive_Meeting {
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            PriorityQueue<String> result = new PriorityQueue<>();
            StringTokenizer str = new StringTokenizer(br.readLine());
            int key = 1;
            while (str.hasMoreTokens()) {
                int val = Integer.parseInt(str.nextToken());
                if (val != 0) {
                    pq.add(new Pair(key, val));
                }
                key++;
            }
            while(!pq.isEmpty()) {
                PriorityQueue<Pair> tmp = new PriorityQueue<>();
                Pair min = pq.remove();
                Pair max = null;
                while(!pq.isEmpty()) {
                    Pair val = pq.remove();
                    if (max == null) {
                        max = val;
                    }
                    else if (val.getValue() > max.getValue()) {
                        tmp.add(max);
                        max = val;
                    }
                    else {
                        tmp.add(val);
                    }
                }

                if (min == null || max == null || min.getValue() > max.getValue()) {
                    break;
                }
                else {
                    if (min.getValue() >= 1 && max.getValue() >= 1) {
                        min.setValue(min.getValue() - 1);
                        max.setValue(max.getValue() - 1);
                        result.add(min.getKey() + " " + max.getKey());
                        count++;
                        if (min.getValue() != 0) {
                            tmp.add(min);
                        }
                        if (max.getValue() != 0) {
                            tmp.add(max);
                        }
                    }
                }
                pq = tmp;
            }
            pw.println(count);
            while (!result.isEmpty()) {
                pw.println(result.remove());
            }
        }
        pw.flush();
    }
}

class Pair implements Comparable<Pair> {
    private int key;
    private int value;
    public Pair (int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.value > this.value) return -1;
        else if (o.value < this.value) return 1;
        else return 0;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Key: " + this.key + ", Value: " + value;
    }
}
