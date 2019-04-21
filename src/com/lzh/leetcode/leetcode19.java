package com.lzh.leetcode;


public class leetcode19 {
    //删除倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
        ListNode node = head.next;//
        ListNode n1 = head;//要删除的节点
        ListNode pre = head;//要删除节点的前一个
        while(i<n){//当n2指针指向第n个节点时，退出循环，两个指针同时移动

            node = node.next;
            i++;
        }
        while(node.next!=null){
            node = node.next;
            pre = n1;
            n1 = n1.next;
        }
        pre.next = n1.next;
        return head;
    }
    public static void main(String[] args){

    }
}
