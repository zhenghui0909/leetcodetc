package com.lzh.leetcode;

public class offer69 {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(100));
    }
    public static int Sum_Solution(int n) {
        int ans = n;
        //ans += Sum_Solution(ans-1);
        boolean t = ((ans!=0) && ((ans += Sum_Solution(n - 1))!=0));
        return ans;
    }
}
