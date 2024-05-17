package com.oycm.algorithm.w;

import com.oycm.algorithm.TreeNode;

public class Solution_1 {

    /**
     * 543.二叉树的直径
     * https://leetcode.cn/problems/diameter-of-binary-tree/
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    int ans = 0;

    public int dfs(TreeNode node) {
        if (node == null) return -1;

        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        ans = Math.max(ans, left+right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

    }
}
