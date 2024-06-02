package LeetCode.Greedy;

/*
    ----------------------------------------------------------------
    | Problem: Jump Game
    | Link: https://leetcode.com/problems/jump-game
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Jump_Game {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int currentIndex = 0;
        int length = nums.length;

        while (true) {
            int numberOfJumps = nums[currentIndex];
            int maxIndex = -1;
            int nextIndex = -1;

            for (int i = currentIndex + 1; i < length && i <= currentIndex + numberOfJumps; i++) {
                int currentNumberOfJumps = i + nums[i];
                if (maxIndex < currentNumberOfJumps) {
                    maxIndex = currentNumberOfJumps;
                    nextIndex = i;
                }
            }

            if (maxIndex >= length - 1) return true;
            if (maxIndex <= currentIndex + numberOfJumps) return false;
            currentIndex = nextIndex;
        }
    }

}
