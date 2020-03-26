package com.junjunlei.o2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 运行时类属性结构获取及内部结构
 * @author junjun.lei
 * @create 2020-03-26 0:31
 */
public class FieldTest {

    @Test
    public void test01(){
        Class clazz=Person.class;

        //获取属性结构
        //getFields()获取当前运行时类及其父类中声明为public 的属性
        Field[] fields=clazz.getFields();
        for(Field field:fields){
            System.out.println(field);
        }

        //getDeclaredFields()获取当前运行时类的所有属性，不包括父类声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field);
        }
    }

    /**
     * 权限 数据类型  变量名
     */
    @Test
    public void test02(){
        Class clazz=Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field:declaredFields){
            //权限修饰符
            int modifiers = field.getModifiers();
            //变量名
            String name = field.getName();
            String str = Modifier.toString(modifiers);
            System.out.println(name+":"+str);

            //数据类型
            Class<?> type = field.getType();
            System.out.println(type);
        }
    }

    /**
     * 获取运行时类的
     */
    @Test
    public void test03(){

    }
}
