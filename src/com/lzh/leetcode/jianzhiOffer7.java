package com.lzh.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class jianzhiOffer7 {
    public static void main(String[] args) {
        int[] num = {11,25,85};
        System.out.println(PrintMinNumber(num));
    }
    public static String PrintMinNumber(int [] numbers) {
        //把整数数组所有数字排成一个数 最大值
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        String s = "";
        for(int l : list){
            s += l;
        }
        return s;
    }
}
