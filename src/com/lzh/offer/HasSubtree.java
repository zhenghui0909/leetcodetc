package com.lzh.offer;


public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //树的子结构
        //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
        boolean flag = false;
        if(root2!=null&&root1!=null){
            if(root1.val==root2.val)
                DoesTree1HaveTree2(root1,root2);
            if(!flag)
                flag = HasSubtree(root1.left,root2);
            if(!flag)
                flag = HasSubtree(root1.right,root2);

        }
        return flag;

    }
    boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){

    }
}
