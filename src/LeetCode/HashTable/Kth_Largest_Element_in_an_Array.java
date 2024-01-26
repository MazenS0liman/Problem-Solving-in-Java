package LeetCode.HashTable;
import java.util.Collections;
import java.util.PriorityQueue;

// Solution: Accepted

public class Kth_Largest_Element_in_an_Array {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {

            pq.add(nums[i]);
        }

        int count = 0;
        while(!pq.isEmpty()) {
            int value = pq.poll();
            count++;
            if (count == k) {
                return value;
            }
        }

        return -1;
    }
}
