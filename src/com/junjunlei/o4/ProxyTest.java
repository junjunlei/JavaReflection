package com.junjunlei.o4;

import org.junit.Test;

/**
 * @author junjun.lei
 * @create 2020-03-27 13:08
 */
public class ProxyTest {
    @Test
    public void test01() {
        SupperMan supperMan=new SupperMan();
        MyInvocationHandle handle = new MyInvocationHandle(supperMan);
        Human proxyInstance = (Human)handle.getProxyInstance();
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("盖浇饭");
    }
}
