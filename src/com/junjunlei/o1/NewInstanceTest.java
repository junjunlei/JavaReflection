package com.junjunlei.o1;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类对象
 *
 * @author junjun.lei
 * @create 2020-03-25 19:37
 */
public class NewInstanceTest {
    @Test
    public void test01() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        /**
         * newInstance 调用此方法创建对应的运行时类的对象
         *
         *
         *         要想此方法正常的创建运行时类的对象，要求：
         *         1.运行时类必须提供空参的构造器
         *         2.空参的构造器的访问权限得够。通常，设置为public。
         *
         *
         *         在javabean中要求提供一个public的空参构造器。原因：
         *         1.便于通过反射，创建运行时类的对象
         *         2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /**
     * 反射的动态性
     */
    @Test
    public void test02() {
         int number=100;
        for (int i = 0; i < number; i++) {
            //0,1,2
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.junjunlei.o1.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个指定类的对象。
     * classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
