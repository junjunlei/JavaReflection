package com.junjunlei.o1;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射测试类
 *
 * @author junjun.lei
 * @create 2020-03-25 16:16
 */
public class ReflectionTest {


    /**
     * 反射之前能进行的操作
     */
    @Test
    public void test01() {
        //创建对象
        Person person = new Person(22, "Tom");
        //通过对象，调用其内部数属性 方法
        person.name = "Jerry";
        // Person{age=22, name='Jerry'}
        System.out.println(person);
        //你好,我是一个人
        person.show();

        //在Person的类外部，不可以通过Person类的对象调用其内部私有结构
        //如 age  showNotation() 及其私有构造
    }


    /**
     * 用反射进行操作
     */
    @Test
    public void test02() throws Exception {

        //1.通过反射创建对象
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(int.class, String.class);
        Object obj = constructor.newInstance(22, "Tom");
        Person person = (Person) obj;
        System.out.println(person);
        //2.通过反射 调用指定对象的属性 方法
        Field field = clazz.getDeclaredField("age");
        //反射私有方法 必须获取访问权限
        field.setAccessible(true);
        field.set(person, 100);
        System.out.println(person.getAge());
        Field name = clazz.getField("name");
        name.set(person, "Jerry");
        System.out.println(person.name);

        //3.通过反射调用方法
        Method show = clazz.getMethod("show");
        show.invoke(person);

        //私有方法调用
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        String nation = (String) method.invoke(person, "中国");
        System.out.println(nation);
    }

    /**
     * 获取Class实例的方式
     */
    @Test
    public void test03() throws Exception {
        //方式一 ： 调用运行时类属性 ：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二 ： 通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三 ： 调用Class的静态方法 forName  (常用)
        Class clazz3 = Class.forName("com.junjunlei.o1.Person");
        System.out.println(clazz3);

        //true
        System.out.println(clazz1 == clazz2);
        //true
        System.out.println(clazz2 == clazz3);


        //方式四 类加载器的使用    ClassLoader(了解)

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.junjunlei.o1.Person");
        System.out.println(clazz4);

    }

    /**
     * Class可以时哪些结构？
     */
    @Test
    public void test04() {

        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
