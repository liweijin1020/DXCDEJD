package com.lwj.chapter3;

/**
 * volatile变量规则:
 *      volatile赋予了变量可见——禁止编译器对成员变量进行优化，它修饰的成员变量在每次被线程访问时，都强迫从内存中重读该成员变量的值；
 *      而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存，这样在任何时刻两个不同线程总是看到某一成员变量的同一个值，这就是保证了可见性.
 * https://blog.csdn.net/piaoslowly/article/details/81476019
 * https://blog.csdn.net/baidu_17508977/article/details/53815687
 *
 * Java多线程volatile和synchronized总结:
 *  https://www.cnblogs.com/wxw16/p/8926535.html
 */
public class VolatileTest {

    private static volatile int LIMIT_VALUE = 0;

    private static final int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = LIMIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != LIMIT_VALUE) {
                    System.out.printf("The value update to [%d]\n", LIMIT_VALUE);
                    localValue = LIMIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = LIMIT_VALUE;
            while (LIMIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                LIMIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }, "UPDATE").start();
    }
}
