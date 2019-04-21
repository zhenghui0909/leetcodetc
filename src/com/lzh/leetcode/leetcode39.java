package com.lzh.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode39 {

    public static void main(String[] args) {



    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return null;
    }
    public void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates,int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        for(int i = num;i < candidates.length&&candidates[i] <= target;i++){
            //深拷贝
            List<Integer> list = new ArrayList<>(tmp);

            list.add(candidates[i]);
            find(listAll,list,candidates,target - candidates[i],i);
        }

    }
}
