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

    public static ListNode getHead(int n) {
        if (n <= 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        int i = 1;
        while (n > 0) {
            list.add(new ListNode(i));
            i++;
            n--;
        }

        for (int j = 1; j < list.size(); j++) {
            list.get(j-1).next = list.get(j);
        }
        return list.get(0);
    }
}
