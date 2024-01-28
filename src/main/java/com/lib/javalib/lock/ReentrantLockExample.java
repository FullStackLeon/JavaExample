package com.lib.javalib.lock;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockExample {
    private static int counter;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void addCounter() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public static int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread addThread = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                ReentrantLockExample.addCounter();
            }
        });

        Thread getThread = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                log.debug("ReentrantLockExample getThread counter:{}", ReentrantLockExample.getCounter());
            }

        });

        addThread.start();
        getThread.start();
        try {
            addThread.join();
            getThread.join();
        } catch (InterruptedException e) {
            log.error("ReentrantLockExample Thread Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
