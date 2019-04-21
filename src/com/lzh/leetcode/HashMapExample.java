package com.lzh.leetcode;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
//        Map map1 = new HashMap();
//        Map map2 = new HashMap();

        map1.put("1","aaa1");
        map1.put("2","bbb2");
        map2.put("10","aaaa10");
        map2.put("11","bbbb11");
//根据键 "1" 取得值："aaa1"
        System.out.println("map1.get(\"1\")="+map1.get("1"));
// 根据键 "1" 移除键值对"1"-"aaa1"
        System.out.println("map1.remove(\"1\")="+map1.remove("1"));
        System.out.println("map1.get(\"1\")="+map1.get("1"));

        map1.putAll(map2);//将map2全部元素放入map1中
        map2.clear();//清空map2
        System.out.println("map1 IsEmpty?="+map1.isEmpty());
        System.out.println("map2 IsEmpty?="+map2.isEmpty());
        System.out.println("map1 中的键值对的个数size = "+map1.size());
        System.out.println("KeySet="+map1.keySet());//set
        System.out.println("values="+map1.values());//Collection
        System.out.println("entrySet="+map1.entrySet());
        System.out.println("map1 是否包含键：11 = "+map1.containsKey("11"));
        System.out.println("map1 是否包含值：aaa1 = "+map1.containsValue("aaa1"));
    }

}
