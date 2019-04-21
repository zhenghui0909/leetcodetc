package com.lzh.leetcode;

public class leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) { val = x; }
         * }
         *
         * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
         * 输出：7 -> 0 -> 8
         * 原因：342 + 465 = 807
         */
        //dummy节
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            int d1 = l1 == null ? 0 : l1.val;
//            int d2 = l2 == null ? 0 : l2.val;
//            int sum = d1 + d2 + carry;
//            carry = sum >= 10 ? 1 : 0;
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        if (carry == 1) cur.next = new ListNode(1);
//        return dummy.next;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //保存进位
        int carry = 0;
        while(l1 != null||l2 != null){
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int d3 = d1 + d2 + carry ;
            carry = d3 / 10;
            cur.next = new ListNode(d3 % 10);
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return dummy.next;



    }
}
