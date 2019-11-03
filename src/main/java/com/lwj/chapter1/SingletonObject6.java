package com.lwj.chapter1;

/**
 * 使用 Holder（类加载） 的方式实现懒汉式
 * 推荐使用这种方式
 */
public class SingletonObject6 {

    private SingletonObject6() {

    }

    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
