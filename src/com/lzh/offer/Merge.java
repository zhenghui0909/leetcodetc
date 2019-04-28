package com.lzh.offer;

import com.lzh.leetcode.ListNode;

public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //合并两个排序的链表
        //输入两个单调递增的链表，输出合并后的链表 要求单调不减
        //时间复杂度o(n)
        if(list2==null)
            return list1;
        if(list1==null)
            return list2;
        ListNode head = null;
        ListNode cur = null;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(head==null){
                    head = cur = list1;
                }else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }else {
                if(head==null){
                    head = cur = list2;
                }else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1==null)
            cur.next = list2;
        if(list2==null)
            cur.next = list1;

        return head;


    }
}
