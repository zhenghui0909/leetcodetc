package com.lzh.leetcode;

import java.util.*;

public class leetcode47 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};

        System.out.println(permuteUnique(nums));
    }
    //全排列数字
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        traceback(nums,0,nums.length-1,result);
        return result;

    }

    //加入start 减少了for循环里的判断
    private static void traceback(int[] nums, int start, int length, List<List<Integer>> res) {
        if (start==length){
            List<Integer> item = new ArrayList<>();
            for (int num:nums) {
                item.add(num);
            }
            res.add(item);
            return;
        }
        for (int i = start; i <=length; i++) {
            if(isDuplicate(nums,start,i)){
                swap(nums,start,i);
                traceback(nums,start+1,length,res);
                swap(nums,start,i);
            }
        }
    }
    //是否为重复数字
    private static boolean isDuplicate(int[] nums, int start, int end) {
        for (int j = start; j <end; j++) {
            if (nums[j]==nums[end]){
                return false;
            }
        }
        return true;
    }
    //交换位置
    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
