package com.lzh.leetcode;

public class leetcode35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int i;
        boolean bool = false;
        for(i=0;i<nums.length;i++){//如果数字在数组中，则在数组中插入
            if(nums[i]==target){
                bool = true;
                break;
            }
        }
        //boolean bool2 = false;
        if (!bool){
            int num;
            for(int j=0;i<nums.length;j++){
                if(nums[j-1]<target&&nums[j]>target){
                    num = nums[j];
                    nums[j] = target;
                    for(int k=j+1;k<nums.length;k++){
                        int tar = nums[k+1];
                        nums[k+1] = nums[k];

                    }
                    nums[j+1] = num;
                    //bool2 = true;//表示已经插入完成
                }else if(target>nums[j]){
                    nums[j+1] = target;
                }

            }
        }

        return nums[i];
    }
}
