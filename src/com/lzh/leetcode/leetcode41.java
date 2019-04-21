package com.lzh.leetcode;

import java.util.Arrays;

public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        /*遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
        然后再遍历一次数组查当前下标是否和值对应，
        如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
*/

        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=1&&nums[i]<=nums.length){
                temp[nums[i]-1] = nums[i];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(temp[i] != i+1)
                return i+1;
        }

        return nums.length + 1;
    }
}
