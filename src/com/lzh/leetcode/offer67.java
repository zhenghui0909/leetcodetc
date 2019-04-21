package com.lzh.leetcode;

public class offer67 {
    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
    public static String ReverseSentence(String str) {
        //翻转单词顺序
        if(str.trim().equals("")){
            return str;
        }
        String[] strs = str.split(" ");
        String res = "";
        for(int i=strs.length-1;i>=0;--i){
            res += strs[i] ;
            if(i != 0)
                res += " ";
        }
        return res;
    }
}
