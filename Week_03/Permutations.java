import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author WhatAKitty
 * @date 2020/05/13
 * @since 1.0.0
 **/
public class Permutations {

    /**
     * 审题：
     * 1. 一个无重复数据的数组集合
     * 2. 返回所有的排列
     * 可能解法：
     * 1. 递归
     * 递归终止条件：
     * * k=0
     * *
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permute(result, new ArrayList<>(), nums);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            permute(result, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(new int[] {1, 2, 3});
        System.out.println(permute);
    }


}
