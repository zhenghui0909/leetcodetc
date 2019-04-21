package com.lzh.leetcode;

public class jianzhiOffer6 {
    public static void main(String[] args) {
        int i = NumberOf1Between1AndN_Solution(123451);
        System.out.println(i);
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        //1出现的次数
        int count = 0;//1的次数
        int i = 1;//当前位
        int before=0,after=0,current=0;
        while(n/i != 0){
            current = (n/i)%10;//高位数字
            before = n/(i*10);//低位数字
            after = n - (n/i)*i;
            if(current==0){
                count += before*i;
            }else if(current==1){
                count += before*i+after+1;
            }else{
                count += (before+1)*i;
            }
            //每次循环i*10 表示进位
            i = i*10;
        }
        return count;
    }
}
