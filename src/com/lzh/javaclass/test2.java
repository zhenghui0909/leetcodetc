package com.lzh.javaclass;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(delete(nums));
    }
    public static int delete(int[] nums){
        int len = nums.length;
        if(len==1)
            return len;
        else if(len==2)
            return len;
        else {
            for(int i=2;i<nums.length;i++){
                if(nums[i]==nums[i-1]&&nums[i]==nums[i-2]){
                    len--;

                }
            }

            return len;
        }



    }
}
