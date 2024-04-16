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

    /**
     * 创建一个dummy节点(哨兵节点),为了删除n=L的情况,知道链表的长度L,删除倒数第n个节点即从哨兵节点开始遍历i=1,当i=L-n+1时,下一个节点就是要删除的节点
     * eg: 0(哨兵) -> 1 -> 2 -> 3 -> 4,删除第4个,从dummy开始,i=1,即dummy.next节点删除
     * eg: 0(哨兵) -> 1 -> 2 -> 3 -> 4,删除第3个节点,从dummy开始i=1,i=2,指向1,下一个节点2就是要删除的
     * @param head 链表的长度
     * @param n 从后面数的第n个节点
     * @return 删除后的链表
     */
    public ListNode method_1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode curr = dummy;
        for (int i = 1; i < length-n+1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }

    /**
     * 创建一个dummy节点，右节点从dummy开始，让其向右移动n次，再指定一个left节点指向dummy，这个时候left节点和right相距n，但是left是right的倒数第n+1节点
     * 当right节点移动到未节点时,即right.next==null，left的下一个节点就是要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode method_2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode right = dummy;
        while (n > 0) {
            n--;
            right = right.next;
        }
        ListNode left = dummy;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        // left下一个节点要被删除
        left.next = left.next.next;

        return dummy.next;
    }
}
