/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * @author WhatAKitty
 * @date 2020/05/28
 * @since 1.0.0
 **/
public class JumpGameII {

    /**
     * 审题：
     * 可能解法：
     * 1. 贪心：在每个节点上眺望跳最大距离
     */
    public int jump(int[] nums) {
        int ans = 0;
        int begin = 0, end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = begin; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }

            begin = end;
            end = maxPos + 1;
            ans++;
        }
        return ans;
    }

}
