package com.junjunlei.o4;

/**
 * 被 代理类
 * @author junjun.lei
 * @create 2020-03-27 11:33
 */
public class SupperMan implements Human {
    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃" + food);
    }
}
