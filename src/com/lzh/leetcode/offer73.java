package com.lzh.leetcode;

public class offer73 {
    boolean isSymmetrical(TreeNode pRoot) {
        //对称的二叉树
        //左子树的右子树和右子树的左子树相同即可
        //递归做法
        if(pRoot==null)
            return true;
        return comRoot(pRoot.left,pRoot.right);
    }
    boolean comRoot(TreeNode left,TreeNode right){
        if(left==null)
            return right==null;
        if(right==null)
            return false;
        if(left.val != right.val)
            return false;

        return comRoot(left.right,right.left) && comRoot(left.left,right.right);
    }
}
