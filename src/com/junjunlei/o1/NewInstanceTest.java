package com.junjunlei.o1;

import org.junit.Test;

/**
 * 通过反射创建对应的运行时类对象
 * @author junjun.lei
 * @create 2020-03-25 19:37
 */
public class NewInstanceTest {
    @Test
    public void test01() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz=Person.class;
        /**
         * newInstance 调用此方法创建对应的运行时类的对象
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }
}
