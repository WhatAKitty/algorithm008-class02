/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author WhatAKitty
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1;
             i < height.length && j > i; ) {
            int currentArea = 0;
            int hi = height[i];
            int hj = height[j];
            if (hi < hj) {
                // i为短板，向内移动i
                currentArea = (j - i) * hi;
                do {
                    i++;
                } while (height[i] < hi);
            } else {
                // j为短板，向内移动j
                currentArea = (j - i) * hj;
                do {
                    j--;
                } while (height[j] < hj);
            }

            max = Math.max(max, currentArea);
        }

        return max;
    }

}
