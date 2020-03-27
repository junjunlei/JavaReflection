package com.junjunlei.o4;

import java.lang.reflect.Proxy;

/**
 *
 * 也可以把 问题一 问题二抽成两个类
 * 代理类
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 *
 * @author junjun.lei
 * @create 2020-03-27 11:34
 */
public class ClassProxy {
    /**
     * 动态获取代理类对象
     *
     * @param obj 被代理类对象
     * @return
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandle handle = new MyInvocationHandle(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handle);
    }
}
