package com.lwj.chapter1;

/**
 * 饿汉式
 *   线程安全，只有一个实例
 *   不支持懒加载
 *   性能较低，消耗资源
 */
public class SingletonObject1 {

    private final static SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
