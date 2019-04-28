package com.lzh.offer;

public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] sequence = {};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        //验证二叉搜索树的后序遍历序列
        //验证二叉搜索树的后序遍历序列
        if(sequence.length==0)
            return false;
        return core(sequence,sequence.length);
    }
    static boolean core(int[] sequence,int length){
        if(sequence==null)
            return false;
        int i = 0;
        int root = sequence[length-1];
        //寻找树的左子树,左子树的值比根节点小
        for(;i<length-1;i++){
            if(sequence[i]>root)
                break;
        }
        int j=i;
        //右子树的值比根节点大
        //如果树的右子树节点值比根节点小，则不是二叉搜索树
        for(;j<length-1;j++){
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;
        if(i>0)
            left = core(sequence,i);

        boolean right = true;
        if(i<length-1)
            right = core(sequence,length-i-1);

        return left&&right;

    }
}
