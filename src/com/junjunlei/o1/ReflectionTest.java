package com.junjunlei.o1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

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
        Person person = new Person(22,"Tom");
        //通过对象，调用其内部数属性 方法
        person.name="Jerry";
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
        Person person=(Person)obj;
        System.out.println(person);
        //2.通过反射 调用指定对象的属性 方法
        Field field = clazz.getDeclaredField("age");
        //反射私有方法 必须获取访问权限
        field.setAccessible(true);
        field.set(person,100);
        System.out.println(person.getAge());
        Field name = clazz.getField("name");
        name.set(person,"Jerry");
        System.out.println(person.name);

        //3.通过反射调用方法
        Method show = clazz.getMethod("show");
        show.invoke(person);

        //私有方法调用
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        String nation=(String) method.invoke(person,"中国");
        System.out.println(nation);
    }
}
