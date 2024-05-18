package com.oycm.algorithm.x;

import com.oycm.algorithm.TreeNode;

public class Solution_1 {

    /**
     * 337.打家劫舍III
     * https://leetcode.cn/problems/house-robber-iii/
     * @param root
     * @return
     */
    public int rob(TreeNode root) {

        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    // int[0] 不选 int[1] 选
    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int chose = left[0] + right[0] + node.val;
        int notChose = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {notChose, chose};
    }
}
