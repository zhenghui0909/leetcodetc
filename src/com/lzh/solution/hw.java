package com.lzh.solution;

import java.util.Scanner;

public class hw {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        if(N%M==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
