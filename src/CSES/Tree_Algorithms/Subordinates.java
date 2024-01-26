package CSES.Tree_Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Wrong Answer

public class Subordinates {

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Node root = new Node(1);

        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = 2;

        while (str.hasMoreTokens()) {
            int val = Integer.parseInt(str.nextToken());
            Node tmp = root;
            while (true) {
                if (val == tmp.data) {
                    Node newChild = new Node(num);
                    tmp.children.add(newChild);
                    tmp.list.add(num);
                    arr[tmp.data]++;
                    break;
                }
                else {
                    for (Node node : tmp.children) {
                        if (node.data == val || node.list.contains(val)) {
                            arr[tmp.data]++;
                            tmp.list.add(num);
                            tmp = node;
                            break;
                        }
                    }
                }
            }

            num++;
        }

        root.display();

        for (int i = 1; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }

        pw.flush();
    }
}

class Node {

    public int data;
    public ArrayList<Node> children;
    public ArrayList<Integer> list;

    public Node (int data) {
           this.data = data;
           this.children = new ArrayList<>();
           this.list = new ArrayList<>();
    }

    public void display() {
        System.out.println("Children of " + this.data + " is:");

        for (Node node : this.children) {
            System.out.print(" " + node.data);
        }

        System.out.println("\nRef of " + this.data + " is:");

        for (int i : this.list) {
            System.out.print(" " + i);
        }

        System.out.println("\n--------------------------------");

        for (Node node : this.children) {
            node.display();
        }
    }
}
