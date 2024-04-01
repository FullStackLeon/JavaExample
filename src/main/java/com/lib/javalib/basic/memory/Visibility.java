package com.lib.javalib.basic.memory;

import static java.lang.System.*;

public class Visibility {
    // volatile 修饰的变量更新会立即刷新到主内存，被其他线程可见
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        // 线程A修改flag的值为false
        new Thread(() -> {
            try {
                Thread.sleep(1000); // 等待一段时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            out.println("Thread A set flag to false.");
        }).start();

        // 线程B检测flag的值，直到为flag=false时退出循环
        new Thread(() -> {
            while (flag) {
                // 空循环
            }
            out.println("Thread B detected flag change to false.");
        }).start();
    }
}

