package com.lzh.offer;

public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        //复杂链表的复制
        //分成三步
        //1.复制所有节点 放在每个节点的后面
        //2.让复制的节点指向复制后的节点
        //3.偶数位的节点就是所要求的复制链表
        if(pHead==null)
            return null;
        RandomListNode curNode = pHead;
        //复制所有节点
        while(curNode!=null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = cloneNode;
            cloneNode.next = nextNode;
            curNode = nextNode;
        }
        curNode = pHead;
        //重新遍历链表，复制老节点的随机指针给新节点
        while(curNode!=null){
            curNode.next.random = curNode.random==null?null:curNode.random.next;
            curNode = curNode.next.next;
        }
        //拆分链表，将链表拆分为原链表和新链表
        curNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(curNode!=null){
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            curNode = curNode.next;
        }
        return pCloneHead;
    }
}
