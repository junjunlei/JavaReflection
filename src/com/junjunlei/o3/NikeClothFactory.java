package com.junjunlei.o3;


/**
 * 被代理类
 * @author junjun.lei
 * @create 2020-03-26 19:22
 */
public class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike生产一批运动服");
    }
}
