package com.example.demo.CollectionAndMap;

import java.util.LinkedList;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/24  9:24.
 * @Modified by:
 */
public class Test1 {


    /**
    * @Author: Zhangxw
    * @Description:LinkedList
    * @Date 9:52  2019/5/24
    * @param 
    * @return 
    */
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add("1");
        linkedList.add(1);
        linkedList.add(2,"123");
        System.out.println(linkedList);
        int o = (int)linkedList.get(1);
        System.out.println(o);
    }
    


}
