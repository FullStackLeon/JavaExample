package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

@Slf4j
public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("a");
        deque.add("b");
        deque.add("c");
       for(String item: deque){
           log.debug("after init,list item:{}", item);
       }

       deque.add("d");
       log.debug("deque first item:{}", deque.peekFirst());
       log.debug("deque last item:{}", deque.peekLast());
       for(String item: deque){
           log.debug("after add,list item:{}",item);
       }

       deque.removeFirst();
       deque.removeLast();
       deque.offer("e");
        for(String item: deque){
            log.debug("after remove and offer,list item:{}",item);
        }
    }
}
