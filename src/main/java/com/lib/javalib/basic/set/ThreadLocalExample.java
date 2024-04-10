package com.lib.javalib.basic.set;

import static java.lang.System.*;

public class ThreadLocalExample {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            new Thread(() -> {
                threadLocalExample.threadLocal.set("localVar" + temp);
                out.println(threadLocalExample.threadLocal.get());
            }, "Thread" + i).start();
        }
    }
}
