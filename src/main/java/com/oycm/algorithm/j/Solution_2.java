package com.oycm.algorithm.j;

import com.oycm.algorithm.TreeNode;

public class Solution_2 {

    /**
     * 对称二叉树
     * https://leetcode.cn/problems/symmetric-tree/description/
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && recursion(left.left, right.right) && recursion(left.right, right.left);
    }
}
