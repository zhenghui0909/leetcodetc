package com.lzh.leetcode;

public class leetcode5 {
    //最长回文子串
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcd"));
    }

    public static String longestPalindrome(String s) {
        //dp算法
        if(s.isEmpty())
            return "";
        if(s.length()==1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0,right = 0,len = 0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                dp[j][i] = (s.charAt(j)==s.charAt(i) && (i - j < 2 || dp[j+1][i-1]));
                if(dp[j][i] && len < i-j+1 ){
                    len = i-j+1;
                    left = j;
                    right = i;
                }
            }
            dp[i][i] = true;
        }
        if(!s.substring(left, left+len).isEmpty())
            return s.substring(left, left+len);
        else
            return s.substring(0,1);
    }
}
