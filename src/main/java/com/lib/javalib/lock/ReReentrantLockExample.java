package com.lib.javalib.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/*
 * reentrant lock get multiple times example
 */
@Slf4j
public class ReReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public void firstGetLock() {
        lock.lock();
        try {
            log.debug("Thread name:{},First time get lock",Thread.currentThread().getName());
            secondGetLock();
        } finally {
            lock.unlock();
        }
    }

    public static void secondGetLock() {
        lock.lock();
        try {
           log.debug("Thread name:{},Second time get lock",Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread name:{} InterruptedException",Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReReentrantLockExample reReentrantLockExample = new ReReentrantLockExample();
        Thread thread = new Thread(reReentrantLockExample::firstGetLock);
        Thread otherThread = new Thread(reReentrantLockExample::firstGetLock); // 方法引用 Method Reference

        thread.start();
        otherThread.start();
        thread.join();
        otherThread.join();
    }
}
