package com.lzh.leetcode;

public class leetcode29 {
    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }


    private static int divide(int dividend, int divisor) {
        //dividend 被除数
        //divisor 除数
        int n = 0;
        for(int i=0;i<dividend;i=i+divisor){
            n++;
        }
        return n-1;
    }
}
