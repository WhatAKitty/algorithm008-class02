/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * 2
 * / \
 * 1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author WhatAKitty
 * @date 2020/05/09
 * @since 1.0.0
 **/
public class ValidateBinarySearchTree {

    /**
     * 审题：
     * 1. 验证二叉搜索树
     * 2. 定义：左子节点小于父亲节点，父亲节点小于右子节点
     * 可能解法
     * 1. 平衡二叉树中序有序，如果当前节点值不在前后值范围内，则不是有效的二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return compare(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean compare(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        return compare(root.left, min, root.val) && compare(root.right, root.val, max);
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
