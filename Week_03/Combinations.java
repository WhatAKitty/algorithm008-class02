import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author WhatAKitty
 * @date 2020/05/10
 * @since 1.0.0
 **/
public class Combinations {

    /**
     * 审题：
     * 1. 从n个数字中提取k个数字，返回所有的可能组合
     * 2. n个数字为1...n的集合
     * 可能解法：
     * 1. 递归
     * 递归终止条件：
     * * k为0——k个数字提取完成
     * 递归公式：
     * * f()
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> comb, int start, int end, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        // 递归其他可能组合
        for (int i = start; i <= end - k + 1; i++) {
            comb.add(i);
            combine(result, comb, i + 1, end, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(3, 3);
        System.out.println(combine);
    }

}
