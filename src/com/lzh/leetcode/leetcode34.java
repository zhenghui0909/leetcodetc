package com.lzh.leetcode;

public class leetcode34 {
    public static void main(String[] args) {

    }
    public static int[] searchRange(int[] nums, int target) {
        int result[] = {-1,-1};
        if(nums==null||nums.length==0) return result;
        FindIndex(result,-1,target,nums);
        FindIndex(result,1,target,nums);
        return result;
    }
    public static void FindIndex(int[] result,int direction,int target,int[] nums){
        //初始化首尾指针，左右界限
        int low = 0,high = nums.length - 1,index = direction==1?nums.length-1:0;
        while(low<high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if(mid ==index||nums[mid+direction]!=target){
                    int temp = (direction==1)?(result[1]=mid):(result[0]=mid);
                    break;
                }else {
                    int temp = (direction==1)?(low=mid+1):(high=mid-1);
                    continue;
                }
            }

        }

    }
}
