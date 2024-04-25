package com.oycm.algorithm.k;

import com.oycm.algorithm.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        TreeNode t1 = new TreeNode(10);
        TreeNode t2L = new TreeNode(8);
        TreeNode t3L = new TreeNode(6);
        TreeNode t4L = new TreeNode(4);
        TreeNode t4R = new TreeNode(7);
        t1.left = t2L;
        t2L.left = t3L;
        t3L.left = t4L;
        t3L.right = t4R;

        System.out.println(solution.method_2_1(t1));



    }

    /**二叉搜索树定义：
     * 节点的左子树(所有)只包含 小于 当前节点的数
     * 节点的右子树(所有)只包含 大于 当前节点的数
     * 所有左子树和右子树自身必须也是二叉搜索树
     * https://leetcode.cn/problems/validate-binary-search-tree/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        boolean preorder = method_1(root, Long.MIN_VALUE, Long.MAX_VALUE);
        boolean inorder = method_2(root);
        boolean inorder_1 = method_2_1(root);
        boolean postorder = method3(root)[1] != Long.MAX_VALUE;
        return false;
    }

    /**
     * 前序遍历，先比较后递归，递归需要知道的边界传递给它
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean method_1(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return method_1(node.left, min, node.val) && method_1(node.right, node.val, max);
    }


    private long pre = Long.MIN_VALUE;

    /** 定义一个最小值pre，利用左节点的值总较小的，如果后面节点的值结果小于等于上一个左节点，则不是
     * 中序遍历：先遍历左子树，再遍历根节点，最后遍历右子树，二叉搜索树保证了左子树的节点的值均小于根节点的值，根节点的值均小于右子树的值，因此中序遍历以后得到的序列一定是升序序列
     * @param root
     * @return
     */
    public boolean method_2(TreeNode root) {
        if (root == null) return true;

        if (!method_2(root.left) || root.val <= pre) {
            return false;
        }

        pre = root.val;

        return method_2(root.right);
    }

    public boolean method_2_1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {

            // 栈是先进后出，把最左边的树压栈，最底下的左子树先弹栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;

        }

        return true;
    }

    /**
     * method3(root) != Long.MAX_VALUE
     * 后续遍历，自底向上计算子问题的过程
     * @param root
     * @return long[0] 最小值 long[1]最大值
     */
    public long[] method3(TreeNode root) {
        if (root == null) {
            return new long[] {Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = method3(root.left);
        long[] right = method3(root.right);

        long x = root.val;
        if (x <= left[1] || x >= right[0]) {
            return new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};

    }
}
