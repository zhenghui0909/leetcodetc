package com.lzh.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class offer74 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //之字形打印二叉树
        //判断层数奇偶
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(!s1.empty()||!s2.empty()){
            if(layer%2!=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    if(node!=null) {
                        temp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                }


            }else {
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s2.empty()){
                    TreeNode node = s2.pop();
                    if(node!=null){
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                }

            }

        }

        return list;
    }
}
