package com.oycm.algorithm.m;

import com.oycm.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
}
