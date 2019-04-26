package com.lzh.leetcode;

import java.util.Stack;

public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        //二叉搜索树的第K个节点
        //中序遍历的第K个节点
        //非递归中序遍历
        if(pRoot==null||k==0)
            return null;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }
        return null;
    }
}
