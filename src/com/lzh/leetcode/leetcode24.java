package com.lzh.leetcode;

public class leetcode24 {

    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;//如果头结点为空，返回空的头结点
        }
        ListNode dump=new ListNode(0);
        dump.next=head;
        head=dump;//声明一个新的节点，将其定义为头结点
        while(head.next!=null&&head.next.next!=null){//next和next.next都不为空
            ListNode n1=head.next;
            ListNode n2=head.next.next;
            head.next=n2;
            n1.next=n2.next;
            n2.next=n1;
            head=n1;
        }
        return dump.next;
    }

    public static void main(String[] args) {

    }
}
