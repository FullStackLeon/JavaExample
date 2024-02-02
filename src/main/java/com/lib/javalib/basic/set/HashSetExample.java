package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Iterator;

@Slf4j
public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            log.debug("after init,list item:{}", iterator.next());
        }

        hashSet.add("d");
        hashSet.forEach(item -> log.debug("after add,list item:{}", item));

        hashSet.remove("d");
        for (String item : hashSet){
            log.debug("after remove,list item:{}", item);
        }

        log.debug("hashSet contains 'a'? {}", hashSet.contains("a"));
    }
}
