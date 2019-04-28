package com.lzh.leetcode;

public class Power {
    public static void main(String[] args) {
        System.out.println(Power(2,-2));
    }
    public static double Power(double base, int exponent) {
        //数值的整数次方
        if(exponent==0)
            return 1;
        int res = 1;
        if(exponent>0){
            for(int i=0;i<exponent;i++){
                res *= base;
            }
        }
        if(exponent<0){
            for(int i=0;i>exponent;i--){
                res *= base;
            }
        }

        return exponent>0? res: 1.0/res ;
    }
}
