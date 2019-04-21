package com.lzh.leetcode;

public class SuperClass {
    int x = 100;
    public void method(SuperClass obj1, SuperClass obj2) {
        System.out.println("SuperClass.method(SuperClass, SuperClass)");
    }
    public void test(int i){
        System.out.println(i);
        i = ++this.x;
        System.out.println(i+" " +x);
    }
    public static void ggg(){//static修饰的方法不能被子类重写
        System.out.println(213231);
        //x = this.x++;
    }

    public static void main(String[] args) {
        SuperClass sup = new SuperClass();
        SubClass sub = new SubClass();
        //((SubClass) sup).test("asfa");
        sup.test(8);
        SuperClass suup = new SubClass();
        SuperClass suuup = sub;
        suuup.ggg();
        suup.method(sup,sup);
        sup.method(sup,sup);

    }
}
class SubClass extends SuperClass {
    public void method(SuperClass superObj, SubClass subObj) {
        System.out.println("SubClass.method(SuperClass, SubClass)");
    }
    public void method(SubClass subObj, SuperClass superObj) {
        System.out.println("SubClass.method(SubClass, SuperClass)");
    }
    public void method(SubClass subObj1, SubClass subObj2) {
        System.out.println("SubClass.method(SubClass, SubClass)");
    }

    @Override
    public void method(SuperClass obj1, SuperClass obj2) {
        System.out.println("dasffa");
    }

    public void test(String str){
        System.out.println(str);
    }

    @Override
    public void test(int i) {
        System.out.println(i+1);
    }
    public static void ggg(){
        System.out.println("fasf");
    }
}
