/**
 * Created with IntelliJ IDEA.
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
