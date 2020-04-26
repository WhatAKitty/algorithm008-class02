import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 *
 * @author WhatAKitty
 * @date 2020/04/27
 * @since 1.0.0
 **/
public class TopKFrequentElements {

    /**
     * 审题：
     * 1. 非空数组
     * 2. 最常使用的k个元素
     * 3. 1 ≤ k ≤ number
     * 4. 时间复杂度必须浩宇O(nlogn)
     * 5. 结果集唯一
     * 6. 返回结果不要求顺序
     * 可能解法：
     * 1. 大顶堆，按照频次排序
     * 测试用例：
     * 1. [1,1,1,2,2,3], 2 -> [1,2]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.compute(n, (key, old) -> {
                if (old == null) {
                    return 1;
                }
                return ++old;
            });
        }

        // 构建小顶堆
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));

        // 入堆一个出堆一个最小值
        counts.entrySet().forEach(entry -> {
            if (heap.isEmpty() || heap.size() < k || entry.getValue() > heap.peek().getValue()) {
                heap.offer(entry);
            }

            if (heap.size() > k) {
                heap.poll();
            }
        });

        int[] result = new int[heap.size()];
        int j = 0;
        for (Map.Entry<Integer, Integer> e : heap) {
            result[j++] = e.getKey();
        }

        return result;
    }

}
