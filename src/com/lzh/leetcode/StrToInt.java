package com.lzh.leetcode;

public class StrToInt {
    public static int StrToInt(String str) {
        //字符串转为整数
        //
        if(str==null||str.trim().equals(""))
            return 0;
        boolean negative = false;
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int radix = 10;

        char firstChar = str.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            }
            i++;
        }
        int multmin = limit / radix;
        int result = 0;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            int digit = Character.digit(str.charAt(i++), radix);
            if (digit < 0 || result < multmin) {
                return 0;
            }
            result *= radix;
            if (result < limit + digit) {
                return 0;
            }
            result -= digit;
        }
        return negative ? result : -result;

    }

    public static void main(String[] args) {
        System.out.println(StrToInt("21a22"));
    }
}
