package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.TreeSet;

@Slf4j
public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");

        Iterator<String> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            log.debug("after init, set item:{}", iterator.next());
        }

        treeSet.add("d");
        treeSet.forEach(item -> log.debug("after add, set item:{}", item));

        treeSet.remove("d");
        for (String item : treeSet) {
            log.debug("after remove, set item:{}", item);
        }
    }
}
