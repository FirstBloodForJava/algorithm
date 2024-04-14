package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(solution.middleNode(l1));
    }

    public ListNode middleNode(ListNode head) {
        return method_1(head);
    }
    public ListNode method_1(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        if ((1+n) % 2 == 0) {
            return getListNodeIndex(head, (1+n)/2);
        }else {
            return getListNodeIndex(head, (1+n)/2+1);
        }

    }
    public ListNode getListNodeIndex(ListNode head, int n) {
        int i = 0;
        while (true) {
            i++;
            if (i == n){
                break;
            }
            head = head.next;
        }
        return head;
    }
}
