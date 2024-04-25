package com.oycm.algorithm.k;

import com.oycm.algorithm.TreeNode;

public class Solution_1 {

    /**二叉搜索树定义：
     * 节点的左子树(所有)只包含 小于 当前节点的数
     * 节点的右子树(所有)只包含 大于 当前节点的数
     * 所有左子树和右子树自身必须也是二叉搜索树
     * https://leetcode.cn/problems/validate-binary-search-tree/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        boolean preorder = method_1(root, Long.MIN_VALUE, Long.MAX_VALUE);
        boolean inorder = method_2(root);
        return false;
    }

    /**
     * 前序遍历，先比较后递归，递归需要知道的边界传递给它
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean method_1(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return method_1(node.left, min, node.val) && method_1(node.right, node.val, max);
    }


    private long pre = Long.MIN_VALUE;

    /** 定义一个最小值pre，利用左节点的值总较小的，如果后面节点的值结果小于等于上一个左节点，则不是
     * 中序遍历，
     * @param root
     * @return
     */
    public boolean method_2(TreeNode root) {
        if (root == null) return true;

        if (!method_2(root.left) || root.val <= pre) {
            return false;
        }

        pre = root.val;

        return method_2(root.right);
    }
}
