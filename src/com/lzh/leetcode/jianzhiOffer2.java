package com.lzh.leetcode;

import java.util.Stack;

public class jianzhiOffer2 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {5,4,3,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        //判断是否可能为该栈的压入顺序
        if(pushA.length==0)
            return false;
        Stack<Integer> stack = new Stack();
        for(int i=0,j=0;i<pushA.length;){
            stack.push(pushA[i++]);
            while(j<popA.length&&stack.peek()==popA[j]){
                //System.out.println(stack.peek());
                stack.pop();
                ++j;
            }
        }
        return stack.isEmpty();
    }
}
