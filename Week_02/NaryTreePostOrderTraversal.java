import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class NaryTreePostOrderTraversal {

    /**
     * 审题：
     * 1. 后续遍历
     * 2. 每个节点下有多个子节点，非二叉树
     * 3. 最大高度小于1000
     * 4. 总结点数在[0, 10^4]之间
     * 可能解法：
     * 1. 递归
     * 2. 栈
     * 3. 颜色标记-栈
     * 测试用例：
     * [1] -> [1]
     * [1,null,3,2,4,null,5,6] -> [5,6,3,2,4,1]
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>();
        if (root.children != null) {
            for (Node item : root.children) {
                result.addAll(postorder(item));
            }
        }
        result.add(root.val);
        return result;
    }

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
