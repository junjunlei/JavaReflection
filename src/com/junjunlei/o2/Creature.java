package com.junjunlei.o2;

import java.io.Serializable;

/**
 * 生物类
 * @author junjun.lei
 * @create 2020-03-25 19:52
 */
public class Creature<T> implements Serializable {
    /**
     * 性别
     */
    private char gender;
    /**
     * 体重
     */
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
