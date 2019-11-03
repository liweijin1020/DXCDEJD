package com.lwj.chapter1;

import java.util.stream.IntStream;

/**
 * 使用枚举类型实现单例设计模式
 */
public class SingletonObject7 {

    private SingletonObject7() {

    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(""+i){
                @Override
                public void run() {
                    System.out.println(SingletonObject7.getInstance());
                }
            }.start();
        }
    }
}
