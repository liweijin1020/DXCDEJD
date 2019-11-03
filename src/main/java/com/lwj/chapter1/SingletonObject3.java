package com.lwj.chapter1;

/**
 * 懒汉式
 *  线程安全，效率较低，变成串行化编程了，每次都要获得锁。
 */
public class SingletonObject3 {

    private static SingletonObject3 instance = null;

    private SingletonObject3() {

    }

    public synchronized static SingletonObject3 getInstance() {
        if(null == instance) {
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }
}
