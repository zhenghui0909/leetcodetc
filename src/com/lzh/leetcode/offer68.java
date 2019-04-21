package com.lzh.leetcode;

public class offer68 {
    public static void main(String[] args) {

        System.out.println(isContinuous(new int[]{1,1,3,0,2}));
    }
    public static boolean isContinuous(int [] numbers) {
        //循环一遍,min纪录最小值，max记录最大值
        //用一个数组来保存出现过的数字，用来判断是否有重复数字
        int[] num = new int[14];
        num[0] = -5;
        int min = 14,max = -1;
        for(int i=0;i<numbers.length;++i){
            num[numbers[i]]++;
            if(num[numbers[i]]>1)
                return false;
            if(numbers[i] == 0)
               continue;
            if(numbers[i]>max)
                max = numbers[i];
            if(numbers[i]<min)
                min = numbers[i];
        }
        if(max - min <5)
            return true;
        else
            return false;
    }
}
