package com.lib.javalib.basic.memory;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.*;

public class Atomicity {
    private static int count = 0;
    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 多线程同时对count进行自增操作，不保证原子性
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    count++;
                }
            }).start();
        }

        // 等待所有线程执行完毕
        Thread.sleep(1000);
        out.println("Non-atomic count: " + count);

        // 使用AtomicInteger保证原子性
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    atomicCount.incrementAndGet();
                }
            }).start();
        }
        // 等待所有线程执行完毕
        Thread.sleep(1000);
        out.println("Atomic count: " + atomicCount.get());

        // Non-atomic 执行结果存在随机性
        // Non-atomic count: 16935
        // Atomic count: 50000
    }
}
