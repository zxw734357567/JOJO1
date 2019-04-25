package com.example.demo;

/**
 * Created by Administrator on 2019-3-31.
 */
public class Test {
    public static void main(String[] args) {
        test1("1");
    }
    public static void test1(String id){
        System.out.println("1");
        if(("1").equals(id)){
            return;
        }else
            {
                System.out.println("2");
            }
        System.out.println("3");
    }
}
