package com.example.demo.CollectionAndMap;

import java.util.TreeMap;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/24  10:08.
 * @Modified by:
 */
public class Test2 {

    public static void main(String[] args) {
        TreeMap treeMap=new TreeMap();
        treeMap.put("1","123");
        treeMap.put("2","2222");
        Dog d0=new Dog(1);
        Dog d2=new Dog(3);

        treeMap.put("dog2",d2);
        treeMap.put("dog1",d0);
        treeMap.put("4","444");
        System.out.println(treeMap);
    }
}
class Dog implements Comparable{
  private int size=0;

    public Dog(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {
        Dog o1 = (Dog) o;
        return o1.size-this.size;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "size=" + size +
                '}';
    }
}
