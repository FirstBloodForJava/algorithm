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
     * a + n(b+c) + b= a + (n+1) b + nc
     * @param head
     * @return
     */
    public ListNode method_2(ListNode head) {

        return null;
    }
}
