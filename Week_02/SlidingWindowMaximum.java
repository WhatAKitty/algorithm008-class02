import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * @author WhatAKitty
 * @date 2020/04/26
 * @since 1.0.0
 **/
public class SlidingWindowMaximum {

    /**
     * 审题：
     * 1. 滑动窗口固定为k个大小
     * 2. 每次移动一个位置
     * 3. 取出每次移动的最大值
     * 4. 1 <= nums.length <= 10^5
     * 5. -10^4 <= nums[i] <= 10^4
     * 6. 1 <= k <= nums.length
     * 可能解法：
     * 1. 每次移动1，窗口开头遍历k个数获取最大值
     * 2. 双指针，初始0，2，每次双指针都移动1，每次夹逼获得最大的一个值
     * 3. 设定一个最大堆（大小为k），移动一个则加入并获取最大值
     * 4. 双端队列
     * 测试用例
     * [1,3,-1,-3,5,3,6,7], 3 -> [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }

        // 大顶堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int start = i - k;
            if (start >= 0) {
                heap.remove(nums[start]);
            }
            heap.offer(nums[i]);
            if (heap.size() == k) {
                result[i - k + 1] = heap.peek();
            }
        }
        return result;
    }

}
