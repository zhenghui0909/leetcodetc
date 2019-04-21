package com.lzh.leetcode;

public class leetcode43 {
    public static String multiply(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        char[] value = new char[num1.length() + num2.length()];
        for(int i=char1.length-1;i>=0;i--){
            for(int j=char2.length-1;j>=0;j--){
                value[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        //处理进位,从低位开始，一次将value[]数组中的每一位对10求余，并对10求商作为进位
        int carry = 0;
        for(int i = value.length - 1;i >= 0;i--){
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }
        //处理前端的0
        int beginIndex = 0;
        while(beginIndex < value.length - 1 && value[beginIndex] == 0){
            beginIndex++;
        }
        for(int i = beginIndex;i< value.length;i++){
            value[i] += '0';
        }

        return new String(value,beginIndex,value.length - beginIndex);
    }

    public static void main(String[] args) {
        System.out.println(multiply("123456","0"));
        System.out.println(multiply("25","6"));
    }
}
