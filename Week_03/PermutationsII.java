import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author WhatAKitty
 * @date 2020/05/14
 * @since 1.0.0
 **/
public class PermutationsII {

    /**
     * 审题：
     * 1. 数字的全排列
     * 可能解决方案：
     * 1. dfs，然后去重
     * 2. dfs过程中判断是否加入过（之前的数字标示为false，则代表这个数字已经被访问过）
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permuteUnique(result, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        return result;
    }

    private void permuteUnique(List<List<Integer>> result, List<Integer> permutation, int[] nums, int start, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i <= permutation.size(); i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;

            used[i] = true;
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            permuteUnique(result, newPermutation, nums, start + 1, used);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        List<List<Integer>> permute = permutations.permuteUnique(new int[] {1, 1, 2});
        System.out.println(permute);
    }



}
