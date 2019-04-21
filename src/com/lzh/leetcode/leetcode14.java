package com.lzh.leetcode;

public class leetcode14 {
    public static void main(String[] args) {
        String[] strs = {"",""};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String res = new String();
        for(int i=0;i<strs[0].length();i++){
            char s = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=s)
                    return res;
            }
            res += String.valueOf(s);
        }

        return res;
    }
//    if (strs == null || strs.length == 0) return "";
//    String res = new String();
//        for (int j = 0; j < strs[0].length(); ++j) {
//        char c = strs[0].charAt(j);
//        for (int i = 1; i < strs.length; ++i) {
//            if (j >= strs[i].length() || strs[i].charAt(j) != c) {
//                return res;
//            }
//        }
//        res += Character.toString(c);
//    }
//        return res;
}
