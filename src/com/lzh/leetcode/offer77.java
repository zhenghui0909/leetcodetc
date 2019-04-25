package com.lzh.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class offer77 {
    //数据流中的中位数
    //大根堆 和 小根堆 实现
    //大根堆装小元素 小根堆装大元素
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if(count%2==0){
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        }else {
            minHeap.offer(num);
            int filterMinNum = minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0)
            return new Double(maxHeap.peek()+minHeap.peek())/2;
        else
            return new Double(minHeap.peek());
    }

}
