package com.lzh.leetcode;

import java.util.ArrayList;

public class offer50 {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(79846444));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //采用双指针以及滑动窗口的思想
        int left=1,right=2;
        while(left<right){

            int cur = (left+right)*(right-left+1)/2;
            //如果cur等于sum，则把窗口内的值全部传入
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                result.add(list);
                left++;
            }else if(cur>sum)
                left++;
            else
                right++;
        }

        return result;

    }
}
