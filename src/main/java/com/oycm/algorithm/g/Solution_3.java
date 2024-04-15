package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {

    /**
     *
     * @param head 链表的头节点
     * @return 环形链表则是尾节点指向的节点, 非环形则节点的值为-1
     */
    public ListNode detectCycle(ListNode head) {
        return null;
    }
    public ListNode method_1(ListNode head) {
        ListNode result = null;
        ListNode curr = head;
        Map<Integer,ListNode> map = new HashMap<>();
        while (curr != null){
            if (!map.containsKey(curr.hashCode())) {
                map.put(curr.hashCode(), curr);
            }else {
                result = map.get(curr.hashCode());
                break;
            }
            curr = curr.next;
        }

        return result;
    }

    /**
     * 如果链表是环,快慢指针最终会在环中相遇
     * 假设环外的长度为a,环入口到相遇点的距离为b,相遇点到入口点的距离是c,则环长=b+c
     * 慢指针移动的距离: a + b
     * 快指针移动的距离: a + n(b+c) + b = a + (n+1)b + nc
     * fast移动距离是slow的2倍,则有: 2(a+b) = a + n(b+c) + b = a + (n+1)b + nc
     * 可以得到: a = c + (n-1)(b+c) 相遇点移动a的距离即移动到入口点
     * 为什么慢指针会只移动b,小于环长, 假设环长为s,快指针和满指针之间的距离为d,则快指针需要多移动s-d才能和慢指针相遇,移动的距离(s-d)/2小于环长
     * @param head
     * @return
     */
    public ListNode method_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    // 头节点和
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
