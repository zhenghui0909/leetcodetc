package com.lzh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(permute(nums));
    }

    //全排列数字
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteDFS(nums,res,new ArrayList<>());
        return res;
    }
    public static void permuteDFS(int[] nums,List<List<Integer>> res,List<Integer> list){
        //递归退出条件
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                permuteDFS(nums,res,list);
                list.remove(list.size() - 1);
            }
        }

    }
}
