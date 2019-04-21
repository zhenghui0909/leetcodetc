package com.lzh.leetcode;

public class leetcode42 {
    public int trap(int[] height) {
        //接雨水
        int n = height.length;
        // left[i]表示i左边的最大值，right[i]表示i右边的最大值
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Integer.max(left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], height[i + 1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            int level = Integer.min(left[i], right[i]);
            water += Integer.max(0, level - height[i]);
        }
        return water;
    }
}
