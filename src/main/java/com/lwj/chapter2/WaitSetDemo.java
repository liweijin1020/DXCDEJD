package com.lwj.chapter2;

import java.util.stream.IntStream;

/**
 * 结论:
 *
 * 1、所有的对象都会有一个wait set，用来存放调用了该对象的wait方法之后进入block状态的线程
 *
 * 2、wait() 调用者是Lock对象，是释放锁的；sleep() 调用者是线程自己，但不释放锁。
 *
 * 3、线程被notify唤醒后，不一定立即执行。
 *
 * ​  唤醒顺序不是FIFO。
 *
 * ​  当线程重新获得锁后，也不会从头开始执行，而是从wait处之后的代码开始继续执行（执行地址恢复）。
 *
 */
public class WaitSetDemo {

    private final static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(0,10).forEach(i ->{
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    synchronized (LOCK) {
                        try {
                            System.out.println("ThreadName -->" + Thread.currentThread().getName() + " enter waitset.");
                            LOCK.wait();
                            System.out.println("ThreadName -->" + Thread.currentThread().getName() + " out waitset.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });

        Thread.sleep(100);

        IntStream.rangeClosed(0,10).forEach(i->{
            synchronized (LOCK){
                LOCK.notify();
            }
        });

    }

}
