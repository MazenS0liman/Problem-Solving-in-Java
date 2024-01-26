package LeetCode.HashTable;

import java.util.Hashtable;

/*
    ----------------------------------------------------------------
    | Problem: Minimum Consecutive Cards to Pick Up
    | Link: https://leetcode.com/contest/weekly-contest-291/problems/minimum-consecutive-cards-to-pick-up/
    | Status: Accepted
    ----------------------------------------------------------------
*/

public class Minimum_Consecutive_Cards_to_Pick_Up {
    public static void main (String[] args) {
        int[] cards = {3,4,2,3,4,7};
        System.out.println(minimumCardPickup(cards));
    }

    public static int minimumCardPickup(int[] cards) {
        Hashtable<Integer, Integer> hTable = new Hashtable<Integer, Integer>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (!hTable.containsKey(cards[i])) {
                hTable.put(cards[i], i);
            }
            else {
                int j = hTable.get(cards[i]);
                if (i - j + 1 < min) {
                    min = i - j + 1;
                }
                hTable.put(cards[i], i);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
