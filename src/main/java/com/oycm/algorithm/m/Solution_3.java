package com.oycm.algorithm.m;

import com.oycm.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
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

    /**
     * 返回层序遍历的最后一个元素的第一个值
     * @param root
     * @return
     */
    public int method_2(TreeNode root) {

        return 1;
    }

    /**
     * 返回从右向左层序遍历，最后出现的left节点就是最左下角的值
     * @param root
     * @return
     */
    public int method_3(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
