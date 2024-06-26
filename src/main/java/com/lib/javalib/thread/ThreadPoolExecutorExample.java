package com.lib.javalib.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException, RuntimeException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1, 60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        // add task to thread pool
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(2000);
                    log.debug("Task execute completed,thread pool state:{},index:{}", getState(threadPoolExecutor), index);
                } catch (InterruptedException e) {
                    log.error("Task execute error,thread pool state:{},index:{}", getState(threadPoolExecutor), index, e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Task execution interrupted", e);
                }
            });
        }

        threadPoolExecutor.shutdown();
        log.debug("After shutdown,thread pool state:{}", getState(threadPoolExecutor));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw e;
        }

        log.debug("thread pool state:{}", getState(threadPoolExecutor));
    }

    private static String getState(ThreadPoolExecutor executor) {
        if (executor.isShutdown()) {
            return "SHUTDOWN";
        } else if (executor.isTerminating()) {
            return "TIDYING";
        } else if (executor.isTerminated()) {
            return "TERMINATED";
        } else {
            return "RUNNING";
        }
    }
}

