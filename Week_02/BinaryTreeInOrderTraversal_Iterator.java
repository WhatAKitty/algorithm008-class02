import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class BinaryTreeInOrderTraversal_Iterator {

    /**
     * 审题：
     * 1. 中序遍历
     * 可能解法：
     * 1. 递归
     * 2. 栈
     * 测试用例：
     * [1] -> [1]
     * [1,1,1,1] -> [1,1,1,1]
     * [1,null,4,2,3] -> [1,2,4,3]
     * [1,1,2,null,null,1] -> [1,1,1,2]
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }

        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
