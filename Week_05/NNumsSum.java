import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WhatAKitty
 * @date 2020/05/24
 * @since 1.0.0
 **/
public class NNumsSum {

    /**
     * 审题：
     * 1. 给定N个数值
     * 2. 找出4个数值求得和为target的组合
     * 可能解法：
     * 1. DFS
     * 测试用例：
     * 1. nums = [1, 0, -1, 0, -2, 2], target = 0
     * ->
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 4, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int target, int k, int start, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (start == k) {
            if (sumOfFourNumsLegal(cur, target)) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        // 不选择该数字
        dfs(nums, target, k, start, sum, cur, result);

        if (nums[start] + )
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, target, k, start + 1, cur, result);
            cur.remove((Object) nums[i]);
        }
    }

    private boolean sumOfFourNumsLegal(List<Integer> cur, int target) {
        int sum = 0;
        for (int item : cur) {
            sum += item;
        }

        return sum == target;
    }

    public static void main(String[] args) {
        NNumsSum nNumsSum = new NNumsSum();
        List<List<Integer>> lists = nNumsSum.fourSum(new int[] {1, 0, -1, -2, 2}, 0);
        System.out.println(lists);
    }

}
