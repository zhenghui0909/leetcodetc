package com.lzh.leetcode;

public class test2 {
    static int i = 5;
    int j = 1;
    static {
        System.out.println(i++
        );
    }
    static {
        System.out.println(i++);
    }
    public static void main(String[] args) {
        System.out.println("begin main method");
        test2 te = new test2();

        System.out.println(i);
    }
}
