package com.junjunlei.o1;

/**
 * 反射测试类
 * @author junjun.lei
 * @create 2020-03-25 16:16
 */
public class Person {
    private int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("无参构造 Person()");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("你好,我是一个人");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
