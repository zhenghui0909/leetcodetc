package com.lzh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        //用hashmap key 存储相同字符的字符串
        HashMap<String,List<String>> map = new HashMap();
        for(String str : strs){
            String t = str;
            char[] charss = t.toCharArray();
            Arrays.sort(charss);
            String flag = String.valueOf(charss);
            List<String> list = map.getOrDefault(flag, new ArrayList<>());
            list.add(str);
            map.put(flag, list);

        }

        return new ArrayList<>(map.values());
    }
}
