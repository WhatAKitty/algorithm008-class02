import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
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
 * @date 2020/04/19
 * @since 1.0.0
 **/
public class LargestRectangleInHistogram {

    private final Node EMPTY = new Node(-1, -1);

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        } else if (heights.length < 2) {
            return heights[0];
        } else if (heights.length < 3) {
            return heights[0] * heights[1];
        }

        Stack<Node> stack = new Stack<>();
        stack.push(EMPTY);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            Node top = stack.peek();
            if (top.height < height) {
                stack.push(new Node(height, i));
            } else {
                stack.pop();
                stack.push(new Node(height, i));
            }
        }

        return result;
    }

    class Node {
        private final int height;
        private final int index;

        public Node(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

}
