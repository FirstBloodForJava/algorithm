package com.oycm.algorithm.m;

import com.oycm.algorithm.TreeNode;

import java.util.Stack;

public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(solution.findBottomLeftValue(root));
    }
    /**
     * 513.找树左下角的值
     * https://leetcode.cn/problems/find-bottom-left-tree-value/
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        deep(root, 0);
        return stack.peek();
    }

    Stack<Integer> stack = new Stack<>();
    public void deep(TreeNode node, int height) {
        if (node == null) return;
        if (stack.size() == height) {
            stack.push(node.val);
        }
        deep(node.left, height+1);
        deep(node.right, height+1);

    }
}
