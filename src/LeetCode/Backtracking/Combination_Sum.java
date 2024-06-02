package LeetCode.Backtracking;

import java.util.*;

/*
    ----------------------------------------------------------------
    | Problem: Combination Sum
    | Link: https://leetcode.com/problems/combination-sum/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Combination_Sum {

    public static void main(String[] args) {
        int target = 11;
        int[] candidates = {8,3,7,4};

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> newCandidateList1 = new ArrayList<>();
        ArrayList<Integer> newCandidateList2 = new ArrayList<>();

        for (int i : candidates) {
            newCandidateList1.add(i);
            newCandidateList2.add(i);
        }

        boolean flag = false;
        int integer = newCandidateList1.get(0);
        newCandidateList2.remove(0);

        ArrayList<Integer> newList1 = new ArrayList<>();
        ArrayList<Integer> newList2 = new ArrayList<>();
        newList1.add(integer);
        List<List<Integer>> tmpResult1  = helper(newList1, integer, newCandidateList1, target);
        List<List<Integer>> tmpResult2  = helper(newList2, 0, newCandidateList2, target);
        if (!tmpResult1.isEmpty()) {
            result.addAll(tmpResult1);
            flag = true;
        }
        if (!tmpResult2.isEmpty()) {
            result.addAll(tmpResult2);
            flag = true;
        }

        if (!flag) {
            return new ArrayList<>();
        }
        else {
            return result;
        }
    }

    public static List<List<Integer>> helper(List<Integer> list, int cumulativeSum, ArrayList<Integer> candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (cumulativeSum == target) {
            result.add(list);
        }
        else if (cumulativeSum > target || candidates.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            boolean flag = false;
            int integer = candidates.get(0);

            ArrayList<Integer> newList1 = new ArrayList<>(list);
            ArrayList<Integer> newList2 = new ArrayList<>(list);
            ArrayList<Integer> newCandidates1 = new ArrayList<>(candidates);
            ArrayList<Integer> newCandidates2 = new ArrayList<>(candidates);

            newCandidates2.remove(0);
            newList1.add(integer);

            int newCumulativeSum = cumulativeSum + integer;
            List<List<Integer>> tmpResult1  = helper(newList1, newCumulativeSum, newCandidates1, target);
            List<List<Integer>> tmpResult2  = helper(newList2, cumulativeSum, newCandidates2, target);

            if (!tmpResult1.isEmpty()) {
                result.addAll(tmpResult1);
                flag = true;
            }
            if (!tmpResult2.isEmpty()) {
                result.addAll(tmpResult2);
                flag = true;
            }

            if (!flag) {
                return new ArrayList<>();
            }
        }

        return result;
    }
}
