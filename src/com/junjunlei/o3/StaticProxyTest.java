package com.junjunlei.o3;

import org.junit.Test;

/**
 * 静态代理 测试
 *
 *  代理类和被代理类在编译器就确定下来了
 * @author junjun.lei
 * @create 2020-03-26 19:14
 */
public class StaticProxyTest {
    @Test
    public void test01() {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        proxy.produceCloth();
    }
}
