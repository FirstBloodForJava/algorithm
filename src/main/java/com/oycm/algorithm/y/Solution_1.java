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
        int[] ans = dfs_simple(root);
        return Math.min(ans[0], ans[2]);
    }

    // int[0] 当前监控; int[1] 父节点监控; int[2] 至少一个子节点监控
    public int[] dfs(TreeNode node) {
        // 为什么为Integer.MAX_VALUE会溢出? 因为到空节点时 当前节点的l[0] r[0] 都会为最大值,在计算黄色时l[0] + r[0] 就溢出了
        if (node == null) return new int[] {Integer.MAX_VALUE / 2, 0 ,0};
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int chose = Math.min(Math.min(l[0], l[1]), l[2]) + Math.min(Math.min(r[0], r[1]), r[2]) + 1;
        int fChose = Math.min(l[0], l[2]) + Math.min(r[0], r[2]);
        int cChose = Math.min(Math.min(l[0] + r[2], l[0] + r[0]), r[0] + l[2]);
        return new int[]{chose, fChose, cChose};
    }

    // 计算公式优化
    public int[] dfs_simple(TreeNode node) {
        // 这里在优化之后，就不会出现溢出了
        if (node == null) return new int[] {Integer.MAX_VALUE, 0, 0};
        int[] l = dfs_simple(node.left);
        int[] r = dfs_simple(node.right);
        int chose = Math.min(l[0], l[1]) + Math.min(r[0], r[1]) + 1;
        int fChose = Math.min(l[0], l[2]) + Math.min(r[0], r[2]);
        int cChose = fChose + Math.max(0, Math.min(l[0] - l[2], r[0] - r[2]));
        return new int[] {chose, fChose, cChose};
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        TreeNode root = new TreeNode(0, new TreeNode(0), null);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(solution.minCameraCover(root));
    }
}
