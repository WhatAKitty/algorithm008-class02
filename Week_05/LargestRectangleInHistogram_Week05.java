/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * @author WhatAKitty
 * @date 2020/05/24
 * @since 1.0.0
 **/
public class LargestRectangleInHistogram_Week05 {

    public int largestRectangleArea(int[] heights) {
        return calculateArea(0, heights.length - 1, heights);
    }

    private int calculateArea(int start, int end, int[] heights) {
        if (start > end) {
            return 0;
        }

        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }

        return Math.max(heights[minIndex] * (end - start + 1),
            Math.max(calculateArea(start, minIndex - 1, heights), calculateArea(minIndex + 1, end, heights)));
    }

}
