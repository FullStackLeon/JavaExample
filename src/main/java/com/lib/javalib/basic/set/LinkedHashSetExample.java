package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Slf4j
public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");

        linkedHashSet.forEach(item -> log.debug("after init,set item:{}", item));
        LinkedHashSet<String> anotherSet = new LinkedHashSet<>();
        anotherSet.add("d");
        anotherSet.add("e");
        anotherSet.add("f");
        anotherSet.add(null);

        linkedHashSet.addAll(anotherSet);
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            log.debug("after add,set item:{}", iterator.next());
        }

        linkedHashSet.remove("a");
        linkedHashSet.forEach(item -> log.debug("after remove,set item:{}", item));
    }
}
