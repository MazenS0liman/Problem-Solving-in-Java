package LeetCode.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    ----------------------------------------------------------------
    | Problem: Keys and Rooms
    | Link: https://leetcode.com/problems/keys-and-rooms
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Keys_and_Rooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (Object key : rooms.get(room)) {
                if (!visited[(int)key]) {
                    queue.add((int)key);
                    visited[(int)key] = true;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
