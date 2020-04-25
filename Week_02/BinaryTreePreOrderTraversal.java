import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class BinaryTreePreOrderTraversal {

    /**
     * 审题：
     * 1. 前序遍历
     * 可能解法：
     * 1. 递归
     * 2. 栈
     * 3. 颜色标记-栈
     * 测试用例：
     * [1] -> [1]
     * [1,1,1,1] -> [1,1,1,1]
     * [1,null,4,2,3] -> [1,2,4,3]
     * [1,1,2,null,null,1] -> [1,1,1,2]
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
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
