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

    /**
     * 慢指针每次移动一个节点，快指针移动两个节点
     * 1 -> n的,有n个节点
     * 奇数情况
     * 快指针移动情况: 1 -> 3 -> 5 -> n是奇数,退出循环条件快指针.next == null
     * 慢指针移动情况: 1 -> 2 -> 3 -> (1+n)/2 结果就是当前的慢指针
     * 偶数情况
     * 快指针移动情况: 1 -> 3 -> 5 -> n是偶数,退出循环条件快指针==null
     * 慢指针移动情况: 1 -> 2 -> 3 -> (1+n)/2+1 结果就是当前的慢指针
     *
     * @param head 单向链表头头节点
     * @return 中间节点
     */
    public ListNode method_2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
