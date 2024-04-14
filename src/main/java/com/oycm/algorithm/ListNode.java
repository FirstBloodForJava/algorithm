package com.oycm.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode nextNode = this.next;
        list.add(this.val);
        while (nextNode != null){
            list.add(nextNode.val);
            nextNode = nextNode.next;
        }

        return list.toString();
    }
}
