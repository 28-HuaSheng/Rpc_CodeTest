package com.test;


import lombok.Data;

/**
 * 链表
 */
@Data
public class ListNode {
    private int value;
    private ListNode next;
    public ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }
    public ListNode(int value){
        this.value = value;
    }

    public static ListNode reverseLinkList(ListNode head){
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode current = head,pre=null;
        while (current!=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
    }
}
