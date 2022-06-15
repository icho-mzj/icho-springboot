package com.icho.base;

import io.netty.channel.Channel;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: icho
 * @Date: 2022/5/30 15:33
 * @Describe:
 */
public class ThreadTest {

    public static void main(String[] args) {

    }

    private static void test07() {
        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.compareAndSet(5,6));
        System.out.println("i = " + i);
    }

    // Runnable
    static class RunnableTest implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }
    }
    private static void test06() {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + "----->" + i);
        }
    }

    // run & start
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
    private static void test05() {
        MyThread mythread = new MyThread("mythread");
        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        mythread.start();
    }

    private static void test04() {
        VolatileTest test = new VolatileTest();
        test.start();
        try {
            Thread.sleep(3000);
            test.setFlag(false);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test.flag = " + test.flag);
    }

    // volatile
    static class VolatileTest extends Thread {
        private volatile boolean flag = true;
        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            System.out.println("run is begin");
            while (this.flag) {
            }
            System.out.println("线程停止");
        }
    }
    volatile static int j = 0;
    private static void test03() {
        System.out.println("j = " + j);
        int total = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(total);
        for (int i = 1;i <= total; i++) {
            new Thread(() -> {
                System.out.println(j++);
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("j = " + j);
    }

    private static ExecutorService service = new ThreadPoolExecutor(
            10,
            100,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>()
    );

    private static void test02() {
        int threadNum = 5;
        AtomicInteger theory = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            service.execute(() -> {
                int waitMillis = new Random().nextInt(5000);
                try {
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"线程执行完,用时:"+waitMillis);
                theory.addAndGet(waitMillis);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("theory = " + theory);
        System.out.println("real: " + (System.currentTimeMillis() - start));
        System.out.println("--- end ---");
    }

    private static void test01() {
        int threadNum = 5;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);


        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                int waitMillis = new Random().nextInt(10000);
                try {
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "已到达目的地,所用毫秒数"+waitMillis);
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- end ---");
    }

}
