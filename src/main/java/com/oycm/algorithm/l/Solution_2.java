package com.oycm.algorithm.l;

import com.oycm.algorithm.TreeNode;

public class Solution_2 {

    /**
     * 二叉搜索树的最近公共祖先,需要利用其有序性，加快搜索
     * 1.当前节点不可能为空，p和q节点都存在给定的二叉搜索树中
     * 2.p和q都在左子树：返回递归左子树的结果
     * 3.p和q都在右子树：返回递归右子树的结果
     * 4.其他：
     * 4.1.p和q分别在左右子树
     * 4.2.当前节点是p
     * 4.3.当前节点q
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;

        if (p.val < x && q.val < x) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
