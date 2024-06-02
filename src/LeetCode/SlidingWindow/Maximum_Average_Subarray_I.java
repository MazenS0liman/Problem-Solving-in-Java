package LeetCode.SlidingWindow;

/*
    ----------------------------------------------------------------
    | Problem: Maximum Average Subarray I
    | Link: https://leetcode.com/problems/maximum-average-subarray-i
    | Status: Solution Accepted
    ----------------------------------------------------------------
*/


public class Maximum_Average_Subarray_I {

    public static void main(String[]args) {
        int[] nums = {-1};
        System.out.println(findMaxAverage(nums, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double maxAvg = -Double.MAX_VALUE;
        int front = 0, back = 0;
        int sum = 0;


        while(front < len) {
            sum += nums[front];
            if (front - back == k - 1) {
                double tmp = sum / (double)k;

                if (tmp > maxAvg) {
                    maxAvg = tmp;
                }
                sum -= nums[back];
                back++;
            }

            front++;
        }

        return maxAvg;
    }

}
