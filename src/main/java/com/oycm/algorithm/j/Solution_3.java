package com.oycm.algorithm.j;

import com.oycm.algorithm.TreeNode;

public class Solution_3 {

    /**
     * 平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1
     *
     * https://leetcode.cn/problems/balanced-binary-tree/description/
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
