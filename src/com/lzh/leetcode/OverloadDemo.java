package com.lzh.leetcode;

public class OverloadDemo {
    public static void main(String[] args) {
        SuperClass superObj = new SuperClass();
        SubClass subObj = new SubClass();
        SuperClass superReferToSub = subObj;

        superObj.method(superObj, superObj);
        superObj.method(subObj, subObj);
        superObj.method(superReferToSub, superReferToSub);
        System.out.println();

        subObj.method(superObj, superObj);
        subObj.method(subObj, subObj);//
        subObj.method(superReferToSub, superReferToSub);
        subObj.method(superObj,subObj);
        subObj.method(subObj,superObj);
        System.out.println();

        superReferToSub.method(superObj, superObj);
        superReferToSub.method(subObj, subObj);
        superReferToSub.method(superReferToSub, superReferToSub);}
}
