package com.example.demo.copyTeset;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zxw
 * @date 2019-08-14 16:22
 */
public class Test {

    public static void main(String[] args) {
        Integer d = new Integer(1);
        Date date = new Date();
        Person p = new Person("1", d, date);
        Person k = new Person();
        Student student=new Student();
        student.setName("张三");
        p.setS(student);
        System.out.println("开始本体    -------" + p);
        BeanUtils.copyProperties(p, k);
        System.out.println("开始复制人------" + k);
        Integer m = new Integer(1);
        String s = new String("2");
        p.setA(s);
        p.setB(m);
        Student student1=new Student();
        student1.setName("李四");
        p.setS(student1);
        System.out.println("本体-------" + p);
        System.out.println("复制人------" + k);

        System.out.println(p.getA()==k.getA());
    }

}
class Student {

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person {
    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    private String a;
    private Integer b;
    private Date c;
    private Student s;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }

    public Person() {
    }

    public Person(String a, Integer b, Date c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                ", s=" + s +
                '}';
    }
}
