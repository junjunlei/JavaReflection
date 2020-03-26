package com.junjunlei.o3;

/**
 * 代理类
 *
 * @author junjun.lei
 * @create 2020-03-26 19:18
 */
public class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做了一些准备");
        clothFactory.produceCloth();
        System.out.println("代理工厂做了一些收尾工作");
    }
}
