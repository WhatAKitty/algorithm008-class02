import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 *
 * @author WhatAKitty
 * @date 2020/04/26
 * @since 1.0.0
 **/
public class NaryTreeLevelOrderTraversal {

    /**
     * 审题：
     * 1. 广度优先遍历
     * 2. 每个节点下有多个子节点，非二叉树
     * 3. 最大高度小于1000
     * 4. 总结点数在[0, 10^4]之间
     * 可能解法：
     * 1. 队列
     * 测试用例：
     * [1] -> [[1]]
     * [1,null,3,2,4,null,5,6] -> [[1],[3,2,4],[5,6]]
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                curLevel.add(curNode.val);
                for (Node node : curNode.children) {
                    queue.offer(node);
                }
            }

            result.add(curLevel);
        }

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
