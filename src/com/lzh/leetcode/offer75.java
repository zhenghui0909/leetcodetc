package com.lzh.leetcode;

import java.util.*;

public class offer75 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //按层打印二叉树
        //使用LinkedList保存每层的节点，start记录开始位置，end记录结束位置
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        int start=0,end=1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
            if(start == end){
                start = 0;
                end = queue.size();
                list.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }

        return list;
    }
}
