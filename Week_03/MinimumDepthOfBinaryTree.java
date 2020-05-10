import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 *
 * @author WhatAKitty
 * @date 2020/05/10
 * @since 1.0.0
 **/
public class MinimumDepthOfBinaryTree {

    /**
     * 审题：
     * 1. 最小深度
     * 2. 根节点到叶子节点的举例
     * 可能解法
     * 1. DFS
     * 2. BFS
     * 测试用例
     * [1,2] -> 2
     * [3,9,20,null,null,15,7] -> 2
     */
    public int minDepth(TreeNode root) {
        return minDepthByDFS(root);
    }

    /**
     * 深度优先遍历
     */
    private int minDepthByDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 广度优先遍历
     */
    private int minDepthByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 层遍历
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            depth++;
        }

        return depth;
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
