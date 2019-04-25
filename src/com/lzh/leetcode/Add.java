package com.lzh.leetcode;

public class Add {
    public static int Add(int num1,int num2) {
        //禁止用四则运算 来做加法
        while(num2!=0){
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Add(18,36));
    }
}
