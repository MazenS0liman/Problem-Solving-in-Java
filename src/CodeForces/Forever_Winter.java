package CodeForces;

// Conditions:
// 1. x > 1 , y > 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Forever_Winter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int j = 0; j < m; j++) {
                String[] s = br.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);

                if (graph[u] == null) {
                    graph[u] = new ArrayList<>();
                }
                if (graph[v] == null) {
                    graph[v] = new ArrayList<>();
                }
                graph[u].add(v);
                graph[v].add(u);
            }

            int a = -1;
            int b = -1;
            int c = -1;
            int x = -1;
            int y = -1;

            for (int j = 1; j < graph.length; j++) {
                if (graph[j].size() != 1) {
                    if (a == -1) {
                        a = graph[j].size();
                    }
                    else if (b == -1 && graph[j].size() != a) {
                        b = graph[j].size();
                    }
                    else if (c == -1 && graph[j].size() != b && graph[j].size() != a) {
                        c = graph[j].size();
                    }
                }
            }

            // Cases:
            if (c == -1) {
                int leafNode = -1;
                int parentNode = -1;

                for (int j = 1; j < graph.length; j++) {
                    if (graph[j].size() == 1) {
                        leafNode = graph[j].size();
                        break;
                    }
                }

                for (int j : graph[leafNode]) {
                    parentNode = j;
                }

                if (graph[parentNode].size() == a) {
                    x = b;
                    y = a - 1;
                }
                else if (graph[parentNode].size() == b) {
                    x = a;
                    y = b - 1;
                }
            }
            else {
                if (c - 1 == a) {
                    x = a;
                    y = b - 1;
                }
                if (c - 1 == b) {
                    x = b;
                    y = a - 1;
                }
                if (a - 1 == b) {
                    x = b;
                    y = c - 1;
                }
                if (a - 1 == c) {
                    x = c;
                    y = b - 1;
                }
                if (b - 1 == a) {
                    x = a;
                    y = c - 1;
                }
                if (b - 1 == c) {
                    x = c;
                    y = a - 1;
                }
            }

//            System.out.println("");
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("c = " + c);
//            System.out.println("");
//            for (int j = 1; j < graph.length; j++) {
//                System.out.println("Node " + j + ": " + graph[j]);
//            }

            pw.println(x + " " + y);
        }
        pw.flush();
    }
}
