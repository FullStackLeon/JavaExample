package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.PriorityQueue;

@Slf4j
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b - a));
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        while(!priorityQueue.isEmpty()) {
            log.debug("after init,queue item:{}", priorityQueue.poll());
        }

        priorityQueue.add(5);
        priorityQueue.add(4);
        while(!priorityQueue.isEmpty()) {
            log.debug("after add,queue item:{}", priorityQueue.poll());
        }
    }
}
