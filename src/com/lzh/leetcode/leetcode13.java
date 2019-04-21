package com.lzh.leetcode;

import java.util.HashMap;

public class leetcode13 {
    public int romanToInt(String s) {
        //int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        //String reps[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        HashMap<String,Integer> map = new HashMap();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int res = 0;
        for(int i=0;i<s.length();i++) {
            if(i == s.length()-1) {
                res += map.get(String.valueOf(s.charAt(i)));
                break;
            }
            if(map.get(String.valueOf(s.charAt(i))) < map.get(String.valueOf(s.charAt(i+1)))){
                res -= map.get(String.valueOf(s.charAt(i)));
            }else{
                res += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }
}
