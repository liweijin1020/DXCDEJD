package com.lwj.chapter1;

/**
 * 懒汉式
 *   线程不安全，可能出现多个实例
 *   延时加载
 */
public class SingletonObject2 {
    private static SingletonObject2 instance = null;

    private SingletonObject2() {

    }

    public static SingletonObject2 getInstance() {
        if (null == instance) {
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
