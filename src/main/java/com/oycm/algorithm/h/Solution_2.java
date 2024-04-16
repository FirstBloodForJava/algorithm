package com.oycm.algorithm.h;

import com.oycm.algorithm.ListNode;

public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        ListNode head = ListNode.getHead(10);
        System.out.println(solution.removeNthFromEnd(head, 7));
    }

    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
     * @param head 头节点
     * @param n 要删除的倒数第n个节点
     * @return 头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 反转链表
        ListNode pre = null;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            count++;
        }

        if (n == 1 && count == 1) {
            return null;
        }
        // 移除头节点
        if (count == n) {
            curr = pre;
            pre = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            pre.val = pre.next.val;
            pre.next = pre.next.next;
            return pre;
        }
        int i = 0;
        ListNode removeNode = pre;
        while (i < n) {
            i++;
            if (i == n) {
                removeNode.val = removeNode.next.val;
                removeNode.next = removeNode.next.next;
            }
            removeNode = removeNode.next;
        }
        // 反转回去
        curr = pre;
        pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
