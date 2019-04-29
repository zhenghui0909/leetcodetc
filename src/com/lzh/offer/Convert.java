package com.lzh.offer;

import java.util.Stack;

public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        //二叉树与双向链表
        //将二叉搜索树转换成一个排序的双向链表
        //非递归方法
        if(pRootOfTree==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;// 将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;//right为后继节点
                p.left = pre;//left为前驱结点
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;

    }
}
