package com.lwj.chapter1;

/**
 * 懒汉式
 *  线程安全，效率较高，两个线程争锁时才会同步，实现并行化。
 *  但可能会出现空指针异常。如实例化对象时，有较多的引用初始化。当第一个线程还没初始化完成，第二个线程进来时，直接return还没初始化完成的实例对象。
 */
public class SingletonObject4 {

    private static SingletonObject4 instance = null;

    private SingletonObject4() {
        // 初始化很多引用
    }

    // double check
    public synchronized static SingletonObject4 getInstance() {
        if(null == instance) {
            synchronized (SingletonObject4.class) {
                if(null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }
        return SingletonObject4.instance;
    }
}
