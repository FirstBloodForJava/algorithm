package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.hasCycle(null));
    }

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
