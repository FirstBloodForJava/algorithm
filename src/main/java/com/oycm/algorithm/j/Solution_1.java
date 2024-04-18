package com.oycm.algorithm.j;

import com.oycm.algorithm.TreeNode;

public class Solution_1 {
    public static void main(String[] args) {

    }
    /**
     * 相同的树
     * https://leetcode.cn/problems/same-tree/description/
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return left;
        }
        boolean right = isSameTree(p.right, q.right);

        return right;
    }
}
