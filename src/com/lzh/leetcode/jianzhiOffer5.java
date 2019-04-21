package com.lzh.leetcode;

import jdk.jfr.Description;

public class jianzhiOffer5 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(nums));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0)
            return 0;
        int res = array[0];
        int times = 1;
        for(int i=1;i<array.length;i++){
            if(times == 0){
                res = array[i];
                times = 1;
            }else if(array[i] == res)
                times++;
            else
                times--;
        }
        if(!checkMoreThanHalf(array,array.length,res))
            return 0;
        return res;
    }
    public static boolean checkMoreThanHalf(int[] array,int length,int number){
        boolean isMoreThanHalf = true;
        int time = 0;
        for(int i=0;i<length;i++){
            if(array[i] == number){
               time++;
            }
        }
        if(time*2<=length)
            return !isMoreThanHalf;
        return isMoreThanHalf;
    }
}
