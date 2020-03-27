package com.junjunlei.o4;

/**
 * 人类接口
 *
 * @author junjun.lei
 * @create 2020-03-26 19:31
 */
public interface Human {
    /**
     * 获取人的信仰
     *
     * @return 返回信仰
     */
    String getBelief();

    /**
     * 吃东西
     *
     * @param food
     */
    void eat(String food);
}
