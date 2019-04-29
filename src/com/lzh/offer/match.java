package com.lzh.offer;

public class match {
    public static void main(String[] args) {
        String str = "aba";
        String pattern = "a*bc*a";
        System.out.println(match(str.toCharArray(),pattern.toCharArray()));
    }
    public static boolean match(char[] str, char[] pattern)
    {
        //正则表达式匹配
        //'.'表示任意一个字符，'*'表示*前面的那个字符可以出现n次（包括0次）
        if(str==null||pattern==null)
            return false;
        return matchCore(str,pattern,0,0);
    }
    static boolean matchCore(char[] str,char[] pattern,int strIndex,int patIndex){
        //如果str与pattern都遍历到了末尾，则返回true
        if(strIndex==str.length&&patIndex==pattern.length)
            return true;
        //pattern先遍历到末尾，则匹配失败
        if(strIndex!=str.length&&patIndex==pattern.length)
            return false;
        if(patIndex+1<pattern.length&&pattern[patIndex+1]=='*'){
            if((strIndex!=str.length&&pattern[patIndex]==str[strIndex])||(pattern[patIndex]=='.'&&strIndex!=str.length))
                //如果字符串和模式的第一个字符匹配
                return matchCore(str,pattern,strIndex,patIndex+2)//模式后移2，视为x*匹配0个字符
                        ||matchCore(str,pattern,strIndex+1,patIndex+2)//视为模式匹配1个字符
                        ||matchCore(str,pattern,strIndex+1,patIndex);//*匹配1个，再匹配str中的下一个
            else
                return matchCore(str,pattern,strIndex,patIndex+2);//如果不匹配，模式后移两位

        }
        if((strIndex!=str.length&&pattern[patIndex]==str[strIndex])||(pattern[patIndex]=='.'&&strIndex!=str.length))
            return matchCore(str,pattern,strIndex+1,patIndex+1);
        return false;
    }
}
