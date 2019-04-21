package com.lzh.leetcode;
import java.lang.reflect.Field;
import java.util.*;
public class offer57 {

    public static void main(String[] args) {
        int[] array = {1,5,7,9,15,26};
        System.out.println(FindNumbersWithSum(array,14));
    }
    //和为s的两个数字
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        int left=0,right=array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(left<right){

            if(array[left]+array[right]<sum){
                left++;
            }else if(array[left]+array[right]>sum)
                right--;
            else{

                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
        }

        return null;
    }

}
