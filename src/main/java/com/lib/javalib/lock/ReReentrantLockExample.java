package com.lib.javalib.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
 * reentrant lock get multiple times example
 */
@Slf4j
public class ReReentrantLockExample {
    private int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public void firstGetLock() {
        lock.lock();
        try {
            log.debug("Thread name:{},First time get lock,count:{}",Thread.currentThread().getName(), count);
            secondGetLock();
        } finally {
            lock.unlock();
        }
    }

    public void secondGetLock() {
        lock.lock();
        try {
           log.debug("Thread name:{},Second time get lock,count:{}",Thread.currentThread().getName(), count);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread name:{} InterruptedException",Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.printf("Thread name:{},count:{}",Thread.currentThread().getName(),count);
        } finally {
            lock.unlock();
        }
    }

    public void tryIncrement() {
        try{
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                try{
                    count++;
                    System.out.printf("Thread name:{},count:{}",Thread.currentThread().getName(),count);
                } finally {
                    lock.unlock();
                }
                
            } else{
                System.out.println("Thread name:{},try lock timeout"+ Thread.currentThread().getName());
            }
        } catch (InterruptedException e){
            System.out.println("Thread name:{},InterruptedException"+ Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReReentrantLockExample reReentrantLockExample = new ReReentrantLockExample();
        Thread thread = new Thread(reReentrantLockExample::firstGetLock);
        Thread otherThread = new Thread(reReentrantLockExample::firstGetLock); // 方法引用 Method Reference


        Thread t1 = new Thread(()-> {
            for(int i=0;i<10;i++){
                reReentrantLockExample.increment();
            }
        }, "t1 thread");

        Thread t2 = new Thread(()-> {
            for(int i=0;i<10;i++){
                reReentrantLockExample.tryIncrement();
            }
        },"t2 thread");

        try {
            thread.start();
            otherThread.start();
            t1.start();
            t2.start();
            thread.join();
            otherThread.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("main thread InterruptedException");
        }
        
    }
}
