package com.lzh.leetcode;

public class movingCount {


    public static void main(String[] args) {


        System.out.println(movingCount(1,3,3));


    }
    public static int movingCount(int threshold, int rows, int cols) {
        //机器人的运动范围
        int flag[][] = new int[rows][cols];
        return helper(threshold, rows, cols,0,0,flag);
    }
    private static int helper(int threshold,int rows,int cols,int i,int j,int[][] flag){
        if(i<0||i>=rows||j<0||j>=cols||flag[i][j]==1||numSum(i)+numSum(j)>threshold)
            return 0;
        /*if(helper(threshold,count,rows,cols,i+1,j)||helper(threshold,count,rows,cols,i,j+1)){
            count++;
            return true;
        }*/
        flag[i][j] = 1;
        return helper(threshold,rows,cols,i+1,j,flag) + helper(threshold,rows,cols,i,j+1,flag) + 1;

    }
    //计算各位数的和
    private static int numSum(int i){
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;

    }
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
}
