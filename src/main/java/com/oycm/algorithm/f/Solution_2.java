package com.oycm.algorithm.f;

import com.oycm.algorithm.ListNode;

public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(l1);
        ListNode result = solution.reverseBetween(l1, 2, 4);
        System.out.println(result);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return method_1(head, left, right);
    }

    /**
     * 实现链表一次复制
     * @param head
     * @return
     */
    public ListNode method_1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode temp = null;
        while ((head = head.next) != null) {
            if (temp == null){
                temp = new ListNode(head.val);
            }else {
                temp.next = new ListNode(head.val);
            }
        }
        result.next = temp;

        return result;
    }

    public ListNode method_1(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int i = 1;
        ListNode result = null;
        ListNode leftTemp = null;
        ListNode headTemp = head;
        // 得到左边的result及尾节点leftTemp
        while (i < left) {
            if (result == null){
                result = new ListNode(headTemp.val);
                leftTemp = result;
            }else {
                leftTemp.next = new ListNode(headTemp.val);
                leftTemp = leftTemp.next;
            }
            headTemp = headTemp.next;
            i++;
        }
        // 反转
        ListNode reverseNode = null;
        ListNode reverseEndNode = null;
        while (i >= left && i <= right){
            reverseNode = new ListNode(headTemp.val, reverseNode);
            if (reverseNode.next == null) {
                reverseEndNode = reverseNode;
            }
            headTemp = headTemp.next;
            i++;
        }
        // 如果前面的leftTemp为null,意味着left==1
        if (leftTemp == null) {
            result = reverseNode;
        }else {
            leftTemp.next = reverseNode;
        }
        // reverseEndNode后面追加元素
        while (headTemp != null){
            reverseEndNode.next = new ListNode(headTemp.val);
            reverseEndNode = reverseEndNode.next;
            headTemp = headTemp.next;
        }

        return result;
    }
}
