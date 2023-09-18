package org.example.concurence;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCostTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            withoutPoolTest();  //10:90 100:130 1000:500 10000:5500 100000:50000
            //withPoolTest();   //10:90 100:100 1000:150 10000:500  100000:6000
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        System.out.println("持续时长：" + duration);

    }

    static void withPoolTest() throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        int i =0;
        while (i<10) {
            int finalI = i;
            CountDownLatch cdl = new CountDownLatch(2);

            ex.execute(()->{
                System.out.println("t1: " + finalI);
                cdl.countDown();
            });

            ex.execute(()->{
                System.out.println("t2: " + finalI);
                cdl.countDown();
            });

            cdl.await();

            i++;
        }

        ex.shutdown();


    }

    static void withoutPoolTest() throws InterruptedException {
        int i =0;
        while (i<10) {
            int finalI = i;
            Thread t1 = new Thread(() -> {
                System.out.println("t1: " + finalI);
            });

            Thread t2 = new Thread(() -> {
                System.out.println("t2: "+ finalI);
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            i++;
        }

    }
}
