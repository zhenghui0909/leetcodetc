package com.lzh.leetcode;

public class offer66 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefg",2));
    }
    public static String LeftRotateString(String str,int n) {
        //左旋转字符串
        char[] chars = str.toCharArray();
        swap(chars,0,n-1);
        swap(chars,n,chars.length-1);
        swap(chars,0,chars.length-1);
        return String.valueOf(chars);
    }
    public static void swap(char[]a,int start,int end){
        char tmp;
        while(start<end){
            tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }
}
