package com.lib.javalib.thread;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class ThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException, RuntimeException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        // add task to thread pool
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.submit(() -> {
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

        executor.shutdown();
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

