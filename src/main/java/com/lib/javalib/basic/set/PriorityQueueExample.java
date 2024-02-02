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
        priorityQueue.add(5);
        priorityQueue.add(4);
        Integer[] list = priorityQueue.toArray(new Integer[0]);
        for (Integer integer : list) {
            log.debug("queue item:{}", integer);
        }

        while(!priorityQueue.isEmpty()) {
            log.debug("after init,queue item:{}", priorityQueue.poll());
        }
    }
}
