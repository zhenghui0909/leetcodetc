package com.lzh.leetcode;

public class test {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;



        head = reverse(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public static ListNode reverse(ListNode head){
        ListNode node = head.next;
        ListNode pre = null;//前驱节点
        ListNode next = null;//后继节点

        while(node.next!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        node.next = pre;
        return node;

    }
}
