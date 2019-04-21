package com.lzh.leetcode;

public class leetcode44 {
    //通配符匹配

    public static void main(String[] args) {

        System.out.println(isMatch("aa","a*****"));

    }
    public static boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        //所以也要初始化value[0][0]为true
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); ++i) {
            if (p.charAt(i-1) == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
