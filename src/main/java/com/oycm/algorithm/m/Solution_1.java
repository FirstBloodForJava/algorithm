package com.oycm.algorithm.m;

import com.oycm.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_1 {

    /**
     * 二叉树的层序遍历
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        deep(root, 0);
        return result;
    }

    public List<List<Integer>> method_1(TreeNode root) {
        deep(root, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    public void deep(TreeNode node, int height) {
        if (node == null) return;
        if (result.size() == height) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            result.add(list);
        }else {
            result.get(height).add(node.val);
        }
        deep(node.left, height+1);
        deep(node.right, height+1);
    }

    /**
     * 双数组层序遍历-两个数组
     * @param root
     * @return
     */
    public List<List<Integer>> method_2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        List<TreeNode> cur = new ArrayList<>();
        if (root != null) cur.add(root);

        while (!cur.isEmpty()) {
            List<TreeNode> nex = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : cur) {
                list.add(node.val);
                if (node.left != null) nex.add(node.left);
                if (node.right != null) nex.add(node.right);
            }
            cur = nex;
            ans.add(list);
        }

        return ans;
    }

    public List<List<Integer>> method_3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>(n);
            while (n > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                n--;
            }
            ans.add(list);
        }
        return ans;
    }
}
