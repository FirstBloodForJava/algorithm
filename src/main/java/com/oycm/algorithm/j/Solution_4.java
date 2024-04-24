package com.oycm.algorithm.j;

import com.oycm.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_4 {

    List<Integer> ans = new ArrayList<>();

    /**
     * 二叉树的右视图
     * https://leetcode.cn/problems/binary-tree-right-side-view/description/
     * 先变量最右边，当高度和结果的size相同时，将结果添加进区，如果到底之后，看左边的是否有满足条件的，知道最后节点为空
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dep(root, 0, result);
        return result;
    }

    public void dep(TreeNode node, int height, List<Integer> result) {
        if (node == null) return;
        if (height == result.size()) {
            result.add(node.val);
        }
        dep(node.right, height+1, result);
        dep(node.left, height +1, result);
    }

    /**
     * 将结果作为局变量
     * @param node
     * @param height
     */
    public void method_1(TreeNode node, int height) {
        if (node == null) return;
        if (height == ans.size()) {
            ans.add(node.val);
        }
        method_1(node.right, height+1);
        method_1(node.left, height+1);
    }
}
