    package com.lib.javalib.debug;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.TimeUnit;

    import static java.lang.System.*;

    // 编译、打包、运行可执行jar包
    // 1. javac com/lib/javalib/debug/HeapDumpExample.java
    // 2. vi Manifest.txt
    //    Main-Class: com.lib.javalib.debug.HeapDumpExample
    // 3. jar cfm HeapDumpExample.jar Manifest.txt com/lib/javalib/debug/HeapDumpExample.class
    // 4. java -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/java/ -jar HeapDumpExample.jar
    public class HeapDumpExample {
        private static final List<int[][]> data = new ArrayList<>();
        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 20; i++) {
                data.add(new int[1024][1024]); // 在这里出现OOM
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
