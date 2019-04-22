package com.lzh.leetcode;

public class offer70 {
    public static void main(String[] args) {

    }
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        //找出环的入口节点
        //首先确定环的节点数量n，然后首先出发的指针向前移动n步，这时第二个指针同时出发

        ListNode meetingNode=meetingNode(pHead);
        if(meetingNode==null)
            return null;
//      得到环中的节点个数
        int nodesInLoop=1;
        ListNode p1=meetingNode;
        while(p1.next!=meetingNode){
            p1=p1.next;
            ++nodesInLoop;
        }
//      移动p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
//      移动p1，p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public static ListNode meetingNode(ListNode head){
        if(head==null)
            return null;

        ListNode slow = head.next;
        if(slow==null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if(slow==fast){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;

            if(fast!=slow){
                fast=fast.next;
            }
        }
        return null;
    }
}
