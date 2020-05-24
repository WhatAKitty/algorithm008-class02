import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 *
 * Output: [1, 3, 9]
 *
 * @author WhatAKitty
 * @date 2020/05/20
 * @since 1.0.0
 **/
public class FindLargestValueInEachTreeRow {

    /**
     * 审题：
     * 1. 找每层最大值
     * 可能解法：
     * 1. BFS
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                max = Math.max(cur.val, max);
            }

            result.add(max);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
