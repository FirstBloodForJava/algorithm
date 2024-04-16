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
                // 最后节点做判断,如果和curr相等,则移除最后节点
                if (next.next == null) {
                    next = null;
                    curr.next = null;
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

    /**
     * 优化: curr的下一个节点不为空，和它比较，
     * 相同则删除，curr.next->curr.next.next，再继续比较curr和curr.next
     * 不相同则curr=curr.next，curr.next!=null，继续比较，指定curr.next==null退出循环
     * @param head
     * @return
     */
    public ListNode method_1(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            if (curr.val == next.val) {
                curr.next = next.next;
            }else {
                curr = curr.next;
            }
        }

        return head;
    }
}
