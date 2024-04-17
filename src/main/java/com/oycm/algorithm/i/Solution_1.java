package com.oycm.algorithm.i;


import com.oycm.algorithm.TreeNode;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left1.left = left2;
        right1.right = right2;
        System.out.println(solution.maxDepth(root));

    }

    /**
     * 二叉树的最大深度
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
     * 在知道左子树和右子树的最大深度l和r时，那么二叉树的深度就是max(l,r)+1
     * 左子树和右子树的最大深度有可以用同样的方式进行计算
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
