package com.oycm.algorithm.f;

import com.oycm.algorithm.ListNode;

public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(l1);
        System.out.println(solution.copyNode(l1));
        System.out.println(solution.reverseKGroup(l1, 5));

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return method_1(head, k);
    }

    public ListNode copyNode(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = head;
        dummyNode.next = pre;
        while (head != null){
            ListNode next = head.next;
            pre.next = next;
            pre = pre.next;
            head = next;
        }
        return dummyNode.next;
    }

    public ListNode method_1(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int i = 1;
        ListNode result = null;
        ListNode resultNext = null;
        ListNode noReverseNode = null;
        ListNode tempNode = null;
        ListNode reverseNode = null;
        ListNode headNode = null;
        ListNode endNode = null;
        while (head != null) {

            // 保留原顺序链表
            if (noReverseNode == null) {
                noReverseNode = new ListNode(head.val);
                tempNode = noReverseNode;
            } else {
                tempNode.next = new ListNode(head.val);
                tempNode = tempNode.next;
            }
            // 反转链表
            reverseNode = new ListNode(head.val, reverseNode);
            if (reverseNode.next == null) {
                endNode = reverseNode;
            } else {
                headNode = reverseNode;
            }

            if (i % k == 0) {
                if (result == null) {
                    result = headNode;
                } else {
                    resultNext.next = headNode;
                }
                resultNext = endNode;
                // 清空
                noReverseNode = null;
                tempNode = null;
                reverseNode = null;
                headNode = null;
                endNode = null;
            }

            head = head.next;
            i++;
        }
        i--;
        if (i % k != 0) {
            resultNext.next = noReverseNode;
        }

        return result;
    }
}
