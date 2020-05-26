import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WhatAKitty
 * @date 2020/05/24
 * @since 1.0.0
 **/
public class Jump {

    /**
     * 审题：
     * 1. 第一步在0索引
     * 2. 按照索引处的数值跳跃
     * 3. 一定能到达最后一个位置
     * 4. 计算最短路径
     * 可能解法：
     * 1. BFS（动态规划
     * 2. 贪心算法：获取每次每个节点的最大可跳跃距离
     */
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int index = 0;
        int maxIndex = nums[0];
        int step = 1;

        while (maxIndex < nums.length - 1) {
            int curMax = 0;
            for (int i = index + 1; i <= maxIndex; i++) {
                if (i + nums[i] > curMax) {
                    // 当前点可以到达的最远距离更长
                    curMax = i + nums[i];
                    index = i;
                }
            }
            // 从当前起点可以到达的终点位置
            maxIndex = index + nums[index];
            //步数加一
            step++;
        }

        return step;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int jump1 = jump.jump(new int[] {2, 3, 1, 1, 4});
        System.out.println(jump1);
    }

}
