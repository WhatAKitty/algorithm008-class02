import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * @author WhatAKitty
 * @date 2020/05/10
 * @since 1.0.0
 **/
public class LowestCommonAncestorOfABinaryTree {

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    /**
     * 审题
     * 1. 查找最近公共祖先
     * 2. 一个节点可以是它自己的祖先
     * 3. 所有节点值唯一
     * 4. p和q节点一定存在于树种
     * 可能解法：
     * 1. DFS遍历
     *      终止条件：
     *          * 叶子节点
     *          * 当前节点为p或q
     *      递归情况：
     *          * 左右子树不为空，返回root
     *          * 左/右子树不为空，返回不为空的子树
     *          * 都为空，返回null
     * 2. 记录所有左右节点的父亲节点，查找pq的最近公共节点（通过访问标记）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        // 自下而上访问p至root的路径
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            // 判断当前节点是否已经访问，是则说明该节点为最近公共祖先节点
            if (visited.contains(q.val)) {
                return q;
            }

            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
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
