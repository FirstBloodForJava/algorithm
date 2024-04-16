package com.oycm.algorithm.h;

import com.oycm.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution_4 {

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
     * 升序排序的链表,重复的元素都删除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public ListNode method_1(ListNode head) {
        if (head == null) return head;

        Set<Integer> set = new HashSet<>();
        // 先删除重复节点，并且记录重复的节点
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                set.add(curr.val);
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        // 遍历无重复的节点，节点有删除记录，则删除节点
        ListNode dummy = new ListNode(-1, head);
        curr = dummy;
        while (curr.next != null) {
            // 之前被删除过
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
 }
