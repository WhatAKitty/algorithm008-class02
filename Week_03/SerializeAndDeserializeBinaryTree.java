import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that
 * a binary tree can be serialized to a string and this string can be deserialized to the
 * original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different
 * approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 *
 * @author WhatAKitty
 * @date 2020/05/10
 * @since 1.0.0
 **/
public class SerializeAndDeserializeBinaryTree {

    private static final String NULL = "N";
    private static final String SPLITER = ",";

    /**
     * 审题
     * 1. 序列化为一个字符串
     * 2. 从字符串反序列化为树
     * 3. 序列化结果的格式不受限制
     * 4. 禁止使用成员/全局/静态变量来存储状态，序列化和反序列化过程需要保持无状态
     * 可能解法：
     * 1. 前序遍历存储；反序列化
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        inOrderBuildString(root, result);

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SPLITER)));
        return buildTree(queue);

    }

    private void inOrderBuildString(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append(NULL).append(SPLITER);
            return;
        }

        result.append(root.val).append(SPLITER);
        inOrderBuildString(root.left, result);
        inOrderBuildString(root.right, result);
    }

    private TreeNode buildTree(Queue<String> data) {
        if (data.isEmpty()) {
            return null;
        }

        String curr = data.poll();
        if (NULL.equals(curr)) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(curr));
        treeNode.left = buildTree(data);
        treeNode.right = buildTree(data);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


}
