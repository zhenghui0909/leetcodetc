package com.lzh.leetcode;

public class leetcode6 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }
    public static String convert(String s, int numRows) {
        //z字形变换
        if(numRows<=1)
            return s;
        int size = 2*numRows - 2;
        String res = "";
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j+=size){
                res += s.charAt(j);
                int tmp = j +size - 2*i;
                if(i!=0 && i!=numRows-1 && tmp<s.length())
                    res+=s.charAt(tmp);
            }
        }
        return res;
    }
}
