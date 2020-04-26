import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author WhatAKitty
 * @date 2020/04/26
 * @since 1.0.0
 **/
public class MinKNums {

    /**
     * 审题：
     * 1. 输出最小的 k 个数字
     * 2. 0 <= k <= arr.length <= 10000
     * 3. 0 <= arr[i] <= 10000
     * 可能解法：
     * 1. 构建最小堆，每次将堆顶删除并存入结果集，执行k次
     * 2. 排序，选择前 k 个数字
     * 3. 构建k个数字的最大堆，每次入堆一个后出堆一个最大值
     * 测试用例：
     * [3], 0 -> []
     * [3], 1 -> [3]
     * [3,2,1,4,7], 2 -> [2,1]
     * [3,2,1], 2 -> [2,1]
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 构建大顶堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int item : arr) {
            if (heap.isEmpty() || heap.size() < k || item < heap.peek()) {
                heap.offer(item);
            }

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            result[j++] = e;
        }

        return result;
    }

}
