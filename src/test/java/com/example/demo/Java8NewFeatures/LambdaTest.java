package com.example.demo.Java8NewFeatures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019-4-22.
 */
public class LambdaTest {

    public static void main(String[] args) {

        //StreamApi的用法 filter ,聚合函数,貌似只有list集合,set集合才有
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //Stram数据源不能含有null元素,不然会提示空指针异常的错误,聚合函数不能
        long count = strings.stream().filter((string) -> {
            if (string.isEmpty()) {
                return true;
            }
            return false;
        }).count();
        System.out.println("字符串长度为 0:" + count);

        //字符串长度为 3
        long count1 = strings.stream().filter((string) -> string.length() == 3).count();
        System.out.println("字符串长度为 3:"+count1);
        List<String> collect = strings.stream().filter((string) -> !string.isEmpty()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        Set<String> strings1 = map.keySet();

    }

}
