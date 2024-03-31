package com.lib.javalib.basic.numeric;

public class BoxUnBoxing {
    public static void main(String[] args) {
        int a = 100;
        Integer b = 100;
        System.out.println(a == b);

        // 两个包装类型
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);

        c = 200;
        d = 200;
        System.out.println(c == d);
    }
}
