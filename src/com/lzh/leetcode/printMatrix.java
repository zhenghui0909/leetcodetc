package com.lzh.leetcode;

import java.util.ArrayList;

public class printMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{2,2}};
        System.out.println(printMatrix(matrix));
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        //
        //顺时针打印矩阵
        ArrayList<Integer> out = new ArrayList<>();
        int column = matrix[0].length;
        int row = matrix.length;
        if(matrix==null||column<=0||row<=0)
            return null;
        int start = 0;
        while(column>start*2&&row>start*2){
            print(matrix,column,row,start,out);
            ++start;
        }
        return out;
    }
    public static void print(int [][] matrix,int column,int row,int start,ArrayList<Integer> out){
        int endX = column - 1 - start;
        int endY = row - 1 - start;
        //从左到右打印一行
        for(int i=start;i<=endX;++i){
            int number = matrix[start][i];
            out.add(number);
        }
        //从上到下打印
        if(endX<endY){
            for(int i=start+1;i<=endY;++i){
                int number = matrix[i][endX];
                out.add(number);
            }
        }
        //从右到左
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;--i){
                int number = matrix[endY][i];
                out.add(number);
            }

        }
        //从下到上
        if(start<endX&&start<endY-1){
            for(int i=endY-1;i>=start+1;--i){
                int number = matrix[i][start];
                out.add(number);
            }
        }
    }

}
