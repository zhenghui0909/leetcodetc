package com.lzh.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class leetcode20 {
    //有效的括号
    //用栈的思想。
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        boolean bol = isValid(str);
        System.out.print(bol);

    }
    public static boolean isValid(String s) {
        //System.out.println(s);
        if(s.isEmpty())
            return true;
        char[] chars = s.toCharArray();
        Stack stack = new Stack();//声明一个栈
        if(chars[0]==')'||chars[0]==']'||chars[0]=='}')
            return false;
        for(int i = 0;i<chars.length;i++){
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                stack.push(chars[i]);
            }else {
                //System.out.print(stack.peek());
                if(stack.isEmpty())
                    return false;
                else if(stack.peek().equals('('))
                    if(chars[i]==')') {
                        stack.pop();
                        continue;
                    }else return false;
                else if(stack.peek().equals('['))
                    if(chars[i]==']') {
                        stack.pop();
                        continue;
                    }else return false;
                else if(stack.peek().equals('{'))
                    if(chars[i]=='}') {
                        stack.pop();
                        continue;
                    }else return false;
                 else if(stack.isEmpty())
                     return false;
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
