package com.oycm.algorithm.g;

import com.oycm.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_4 {
    public void reorderList(ListNode head) {

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
}
