package com.oycm.algorithm.h;

import com.oycm.algorithm.ListNode;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        ListNode head = ListNode.getHead(3);
        System.out.println(head);
        solution.deleteNode(head.next);
        System.out.println(head);

    }

    /**
     * https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
     * 由于删除的不是链表的末尾节点 node.next != null
     * 把当前对象的值改为下一个节点的值
     * 把当前对象的next指向下一个节点的next节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
