package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_4 {

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        ListNode head = ListNode.getHead(10);
        System.out.println(head);
        solution.method_2(head);
        System.out.println(head);

    }

    public void reorderList(ListNode head) {
        method_1(head);
    }
    public void method_1(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 寻找中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    public void method_2(ListNode head) {
        // 寻找链表的中间节点
        ListNode middleNode = middleNode(head);
        // 将中间节点之后的节点反转
        ListNode rightHead = reverseNode(middleNode);

        while (rightHead.next != null) {
            ListNode leftNext = head.next;
            ListNode rightNext = rightHead.next;
            head.next = rightHead;
            rightHead.next = leftNext;
            head = leftNext;
            rightHead = rightNext;
        }

    }
}
