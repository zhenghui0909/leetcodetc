package com.lzh.leetcode;

public class minNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = new int[]{6,7,9,2,3,6};
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        //旋转数组的最小数字
        if(array==null)
            return 0;
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while(array[index1]>=array[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if(array[indexMid]>=array[index1])
                index1 = indexMid;
            if(array[indexMid]<=array[index2])
                index2 = indexMid;
        }

        return array[indexMid];
    }
}
