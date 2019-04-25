package com.lzh.leetcode;

import java.util.*;

public class offer78 {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5,6,3,23,52,2,42,52,22};

        System.out.println(maxInWindows(num,2));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        //滑动窗口的最大值
        //使用双端队列思想
        /**
         * 题目：滑动窗口的最大值
         * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
         *     原则：
         *     对新来的元素k，将其与双端队列中的元素相比较
         *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
         *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
         *     队列的第一个元素是滑动窗口中的最大值
         *
         */
        ArrayList<Integer> ret = new ArrayList<>();
        if(num==null||size<=0||num.length<size)
            return ret;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<num.length;++i){
            //判断是否需要移除队尾元素(如果比当前元素小)
            while(!queue.isEmpty()&&num[queue.peekLast()]<num[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            //判断队首元素是否过期
            if(queue.peekFirst() == i-size)
                queue.pollFirst();
            //向result中加入元素
            if(i>=size-1)
                ret.add(num[queue.peekFirst()]);
        }

        return ret;
    }
}
