package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class StackExample {
    public static void main(String[] args) {
        Stack<String> list = new Stack<>();
        list.push("a");
        list.push("b");
        list.push("c");
        for (int i = 0; i < list.size(); i++) {
            log.debug("after init,list item:{}", list.get(i));
        }

        list.push("d");
        for(String item:list){
            log.debug("after add,list item:{}", item);
        }
        log.debug("before remove top,stack top item:{}", list.peek());
        list.pop();
        log.debug("after remove top,stack top item:{}", list.peek());
        list.set(0, "abc");
        for (String item:list){
            log.debug("after pop,list item:{}", item);
        }
    }
}
