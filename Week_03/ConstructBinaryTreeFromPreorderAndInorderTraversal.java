import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Medium
 *
 * 2916
 *
 * 85
 *
 * Add to List
 *
 * Share
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author WhatAKitty
 * @date 2020/05/10
 * @since 1.0.0
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 审题：
     * 1. 给出先序和中序顺序
     * 2. 先序确定根，中序确定左右子树
     * 可能解法：
     * 1. 递归
     *      递归终止条件：
     *          * 当前集合内元素为1
     *      递归公式：
     *          * f(p,q) = f(p, p+in_index_x) + f(p+in_index_x, q)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i : preorder) {
            queue.add(i);
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(inorder, queue, 0, preorder.length - 1, inMap);
    }

    private TreeNode dfs(int[] inorder, Queue<Integer> preorder, int start, int end, Map<Integer, Integer> inMap) {
        if (start > end) {
            return null;
        }

        Integer root = preorder.poll();
        Integer mid = inMap.get(root);  // 分割点

        TreeNode treeNode = new TreeNode(root);

        TreeNode left = dfs(inorder, preorder, start, mid - 1, inMap);
        TreeNode right = dfs(inorder, preorder, mid + 1, end, inMap);

        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
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

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNode = constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

}
