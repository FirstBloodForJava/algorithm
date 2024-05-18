package com.oycm.algorithm.y;

import com.oycm.algorithm.TreeNode;

public class Solution_1 {

    /**
     * 968.监控二叉树
     * https://leetcode.cn/problems/binary-tree-cameras/
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        int[] ans = dfs(root);
        return Math.min(ans[0], ans[2]);
    }

    // int[0] 当前监控; int[1] 父节点监控; int[2] 至少一个子节点监控
    public int[] dfs(TreeNode node) {
        if (node == null) return new int[] {10000, 0 ,0};
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int chose = Math.min(Math.min(l[0], l[1]), l[2]) + Math.min(Math.min(r[0], r[1]), r[2]) + 1;
        int fChose = Math.min(l[0], l[2]) + Math.min(r[0], r[2]);
        int cChose = Math.min(Math.min(l[0] + r[2], l[0] + r[0]), r[0] + l[2]);
        return new int[]{chose, fChose, cChose};
    }
}
