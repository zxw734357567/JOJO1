package com.example.demo.ThreadTest;

/**
 * @Author zhangxw
 * @Description:修饰一个静态的方法
 * @Date Created in 2019/5/24  11:29.
 * @Modified by:
 */
public class Test5 {
    public static void main(String[] args) {
        SyncThread1 syncThread1 = new SyncThread1();
        SyncThread1 syncThread2 = new SyncThread1();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

/**
 * 同步线程
 */
class SyncThread1 implements Runnable {
    private static int count;

    public SyncThread1() {
        count = 0;
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void run() {
        method();
    }
}
