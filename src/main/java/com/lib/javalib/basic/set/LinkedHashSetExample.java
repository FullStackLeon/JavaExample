package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Slf4j
public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");

        linkedHashSet.forEach(item -> log.debug("after init,list item:{}", item));
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("d");
        anotherSet.add("e");
        anotherSet.add("f");

        linkedHashSet.addAll(anotherSet);
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            log.debug("after add,list item:{}", item);
        }

        linkedHashSet.remove("a");
        linkedHashSet.forEach(item -> log.debug("after remove,list item:{}", item));
    }
}
