import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class TwoSum_Week2 {

    /**
     * 审题：
     * 1. 返回两数之和为目标值的索引位置对
     * 2. 假设只有一个解
     * 3. 不能重复使用相同的元素
     * 可能解法：
     * 1. 双层循环相加比较
     * 2. 遍历的时候存入map，如果已经存在与目标值一致的则直接返回
     * 测试用例：
     * [2,2], 4 -> [0,1]
     * [2,7,11,15], 9 -> [0,1]
     * [2,7,11,15], 13 -> [0,2]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapping = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int toFind = target - num;
            if (mapping.containsKey(toFind)) {
                return new int[]{mapping.get(toFind), i};
            } else {
                mapping.put(num, i);
            }
        }

        throw new IllegalArgumentException();
    }

}
