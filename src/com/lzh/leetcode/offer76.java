package com.lzh.leetcode;

public class offer76 {
    int[] hash = new int[256];
    StringBuffer s = new StringBuffer();
    public void Insert(char ch)
    {
        //字符流中第一个不重复的字符
        //一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
        // 时间复杂度为O(n)，空间复杂度O(n).
        s.append(ch);
        if(hash[ch]==0)
            hash[ch] = 1;
        else
            hash[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chars = s.toString().toCharArray();
        for(char c:chars){
            if(hash[c]==1)
                return c;
        }
        return '#';
    }

}
