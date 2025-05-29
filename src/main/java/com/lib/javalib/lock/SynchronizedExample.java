package com.lib.javalib.lock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedExample {
    private int counter;

    public final synchronized void addCounter() {
        counter++;
    }

    public final synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        // lambda expression
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedExample.addCounter();
            }
        }, "AddThread");

        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                log.debug("getThread counter:{}", synchronizedExample.getCounter());
            }
        }, "GetThread");

        addThread.start();
        getThread.start();
        try {
            addThread.join();
            getThread.join();
        } catch (InterruptedException e) {
            log.error("Thread Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}