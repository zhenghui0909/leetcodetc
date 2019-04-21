package com.lzh.leetcode;

public class leetcode28 {
    public static void main(String[] args) {

    }
    public static int strStr(String haystack, String needle) {
        /*char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();//转成字符数组
        for(int i = 0;i<chars.length;i++){
            for(int j=i;j<chars1.length;j++){
                if(chars[i]==chars1[j]){
                    continue;
                }else {
                    break;
                }
            }
        }
        return 0;*/
        int index = haystack.indexOf(needle);//查找字符串中的子串，并返回子串起始位置
        return index;
    }

}
