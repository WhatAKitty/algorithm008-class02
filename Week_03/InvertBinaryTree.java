/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 *
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 * @author WhatAKitty
 * @date 2020/05/09
 * @since 1.0.0
 **/
public class InvertBinaryTree {

    /**
     * 审题
     * 1. 二叉树
     * 2. 左右字数交换
     * 可能解法：
     * 1. 后序遍历交换值
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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

