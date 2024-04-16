package com.oycm.algorithm.h;

import com.oycm.algorithm.ListNode;

public class Solution_3 {
    public static void main(String[] args) {
        ListNode head = ListNode.getHead(10);
        ListNode head1 = ListNode.getHead(1);
        head1.next = head;
        Solution_3 solution = new Solution_3();
        System.out.println(solution.deleteDuplicates(head1));
    }

    /**
     * 升序链表,删除重复元素
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {

            if (curr.val == next.val) {
                // 删除节点 curr不变,curr.next->next.next
                ListNode nextNext = next.next;
                // 最后节点做判断,如果和curr相等,则移除最后节点
                if (nextNext == null) {
                    if (curr.val == next.val) {
                        curr.next = nextNext;
                    }
                    break;
                }else {
                    curr.next = next.next;
                    next = curr.next;
                }

            } else {
                curr = next;
                next = curr.next;
            }
        }
        return head;
    }
}
