package com.oycm.algorithm.w;

import com.oycm.algorithm.TreeNode;

public class Solution_2 {

    /**
     * 124.二叉树中的最大路径和
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        return 0;
    }

    int ans = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        ans = Math.max(ans, node.val);

        int left = dfs(node.left);
        int right = dfs(node.right);

        ans = Math.max(ans, node.val + left + right);
        // 子问题：当前节点的最大值，如果为负，不选，返回0
        return Math.max(node.val + Math.max(left, right), 0);
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();

        TreeNode root = new TreeNode(-1);
        TreeNode left1 = new TreeNode(-2);
        TreeNode right1 = new TreeNode(-3);
        root.left = left1;
        root.right = right1;

        System.out.println(solution.dfs(root));
        System.out.println(solution.ans);
    }
}
