package com.lib.javalib.lock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class FairNonFairLockExample {
    private static final ReentrantLock FairLock = new ReentrantLock(true);
    private static final ReentrantLock NoFairLock = new ReentrantLock();

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new Task(FairLock, "FairLockThread:"+i).start();
            new Task(NoFairLock, "NoFairLockThread:"+i).start();
        }
    }

    @AllArgsConstructor
    static class Task extends Thread {
        private ReentrantLock lock;
        private  String name;

        @Override
        public void run() {
            try {
                log.debug(name + " is waiting to acquire the lock");
                lock.lock();
                log.debug(name + " has acquired the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(name + " was interrupted");
            } finally {
                lock.unlock();
                log.debug(name + " has release the lock");
            }
        }
    }
}
