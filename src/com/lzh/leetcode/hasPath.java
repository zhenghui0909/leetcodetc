package com.lzh.leetcode;

public class hasPath {

    //矩阵中的路径
    //回溯法
    //用一个状态数组保存之前访问过的字符，再分别按上下左右递归

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(helper(matrix,rows,cols,str,0,flag,i,j))
                    return true;
            }
        }
        return false;
    }
    private static boolean helper(char[] matrix, int rows, int cols, char[] str,int k,int[] flag,int i,int j){
        int index = i * cols + j;
        if(i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1)
            return false;
        if(k==str.length-1)
            return true;
        flag[index] = 1;
        if(helper(matrix,rows,cols,str,k+1,flag,i-1,j)
            ||helper(matrix,rows,cols,str,k+1,flag,i+1,j)
                ||helper(matrix,rows,cols,str,k+1,flag,i,j+1)
                ||helper(matrix,rows,cols,str,k+1,flag,i,j-1)
        )
            return true;
        flag[index] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = new char[]{'a','c','c','e'};
        System.out.println(hasPath(matrix,3,4,str));

    }
}
