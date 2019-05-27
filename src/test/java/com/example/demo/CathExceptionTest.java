package com.example.demo;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/22  14:24.
 * @Modified by:
 */
public class CathExceptionTest {
    public static void main(String[] args) {
        String test = test();
        System.out.println(test);
    }

    public static String test(){
        try {
            int a=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        }
        return "1";
    }
}
