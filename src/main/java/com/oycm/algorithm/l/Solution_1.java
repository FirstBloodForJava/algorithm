package com.oycm.algorithm.l;

import com.oycm.algorithm.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1 {

    /**
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
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
