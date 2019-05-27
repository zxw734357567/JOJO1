package com.example.demo;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019-3-31.
 */
public class Test {

    public static void main(String[] args) {
        test1("1");
    }

    public static void test1(String id) {
        String a = "1";
        String b = "1";
        String c = new String("c");
        String d = new String("c");
        Integer h = 1;
        Integer m = 1;
        Integer k = new Integer(1);
        Integer n = new Integer(1);
        int g = 1;
        int f = 1;
        Integer test = getTest();//引用
        System.out.println(test == h);
        System.out.println(test == k);
        System.out.println(k == n);
        System.out.println(h == m);
        System.out.println(g == f);
        System.out.println(a == b);
        System.out.println(c == d);
    }

    static Integer getTest() {
        return 1;
    }
}
