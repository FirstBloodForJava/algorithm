package com.oycm.algorithm.l;

import com.oycm.algorithm.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();



    }

    /**
     * 236.二叉树的最近公共祖先
     * 原问题子问题化：扫描二叉树的左右节点，如果节点为空，则返回null，代表这个子树没有p或q，当找到一个节点p或q时，返回当前节点
     * 当找到p时：
     * 1.如果q在p节点的左子树，则p就是最近公共祖先
     * 2.如果q在p节点的右字数，则p就是最近公共祖先
     * 3.如果q在p节点另一侧，这个时候如果q节点有找到，则当前节点就是最近祖先
     * 当找到q时是同理
     * 可以分类讨论：
     * 1.节点为null时，返回null(当前节点)
     * 2.节点为p时，返回当前节点
     * 3.节点为q时，返回当前节点
     * 4.其他情况：
     * 4.1.左右字数都找到系欸但，则当前节点就是结果
     * 4.2.只有左字数找到，则返回递归左子树的结果
     * 4.3.自由右字数找到，则返回递归右子树的结果
     * 4.4.左右字数都没有找到，返回null
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果为空或找到某个节点
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    // 记录当前节点的父节点
    Map<Integer,TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

    private TreeNode method_1(TreeNode root, TreeNode p, TreeNode q) {
        map.put(root.val, null);
        dfs(root);
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while (!set.contains(q.val)) {
            q = map.get(q.val);
        }

        return q;
    }
}
