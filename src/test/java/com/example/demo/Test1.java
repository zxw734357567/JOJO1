package com.example.demo;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/11  16:20.
 * @Modified by:
 */
public class Test1 {
    public static void main(String[] args) {
        String a=null;
        String[] split = a.split(",");
        for (int i=0;i<split.length;i++){
            System.out.println(split[i]);
        }
    }
}
