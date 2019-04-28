package com.lzh.offer;


public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //树的子结构
        //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
        //递归做法：
        boolean flag = false;
        if(root2!=null&&root1!=null){
            if(root1.val==root2.val)//树2的根节点和树1当前访问节点相等，则判断是不是子结构
                flag = DoesTree1HaveTree2(root1,root2);

            if(!flag)//如果不是子结构，则递归root1的left节点
                flag = HasSubtree(root1.left,root2);
            if(!flag)//如果不是子结构，则递归root1的right节点
                flag = HasSubtree(root1.right,root2);
        }
        return flag;

    }
    boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2==null)//如果root2为null，则返回true
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right
        ,root2.right);
    }
}
