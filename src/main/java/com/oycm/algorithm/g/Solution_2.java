package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.hasCycle(null));
    }

    /**
     *
     * @param head 链表的头节点
     * @return true-链表是环形的尾节点指向前面的其中一个节点
     */
    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
