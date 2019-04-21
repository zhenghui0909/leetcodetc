package com.lzh.javaclass;

public class Test {

    public static void main(String[] args) {
        System.out.println(f(0));
    }
    public static int f(int x){

        if(x==0)
            return 1;
        else
            return x*f(x-1);
    }


}
