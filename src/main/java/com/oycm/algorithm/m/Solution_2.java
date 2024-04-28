package com.oycm.algorithm.m;

import com.oycm.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_2 {

    /**
     * 二叉树的锯齿形层序遍历 - 双端队列
     * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int height = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> list = new ArrayList<>(n);
            if (height % 2 == 0) {
                while (n > 0) {
                    TreeNode node = deque.removeFirst();
                    list.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    n--;
                }
            }else {
                while (n > 0) {
                    TreeNode node = deque.removeLast();
                    list.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                    n--;
                }
            }
            ans.add(list);
            height++;
        }
        return ans;
    }
}
