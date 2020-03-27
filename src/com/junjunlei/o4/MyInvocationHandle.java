package com.junjunlei.o4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 *
 * @author junjun.lei
 * @create 2020-03-27 12:38
 */
public class MyInvocationHandle implements InvocationHandler {

    /**
     * 被代理类对象
     */
    private Object obj;

    public MyInvocationHandle(Object obj){
        this.obj=obj;
    }

    /**
     * 动态获取代理类对象
     *
     * @return
     */
    public  Object getProxyInstance() {
        return Proxy.newProxyInstance(this.obj.getClass().getClassLoader(),this.obj.getClass().getInterfaces(),this);
    }

    /**
     * 动态的去调用被代理类中的同名方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(this.obj, args);
        return returnValue;
    }
}
