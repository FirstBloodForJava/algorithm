package com.oycm.algorithm.f;

import com.oycm.algorithm.ListNode;

public class Solution_1 {

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        Solution_1 solution = new Solution_1();
        ListNode result = solution.reverseList(l1);
        System.out.println(result.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(head.val);
        ListNode temp = head;
        while ((temp = temp.next) != null){
            result = new ListNode(temp.val, result);
        }

        return result;
    }

    /**
     * 空间复杂度优化
     * @param head
     * @return
     */
    public ListNode method_1(ListNode head) {
        ListNode result = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = result;
            result = curr;
            curr = next;
        }

        return result;
    }
}

