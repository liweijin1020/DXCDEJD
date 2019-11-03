package com.lwj.chapter1;

/**
 * 懒汉式
 *  线程安全，效率较高，两个线程争锁时才会同步，实现并行化。
 *  解决空指针异常：加上volatile关键字
 */
public class SingletonObject5 {

    private static volatile SingletonObject5 instance = null;

    private SingletonObject5() {
        // 初始化很多引用
    }

    // double check
    public synchronized static SingletonObject5 getInstance() {
        if(null == instance) {
            synchronized (SingletonObject5.class) {
                if(null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }
        return SingletonObject5.instance;
    }
}
