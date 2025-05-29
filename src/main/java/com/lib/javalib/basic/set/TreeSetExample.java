package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.SortedSet;
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
        treeSet.forEach(item->log.debug("after add, set item:{}", item));

        SortedSet<String> headSet = treeSet.headSet("d"); // 返回小于d的元素
        for (String item : headSet) {
            log.debug("after headSet, set item:{}", item);
        }

        treeSet.tailSet("d");
        SortedSet<String> tailSet = treeSet.tailSet("a"); // 返回大于等于a的元素
        for (String item : tailSet) {
            log.debug("after tailSet, set item:{}", item);
        }

        treeSet.remove("d");
        for (String item : treeSet) {
            log.debug("after remove, set item:{}", item);
        }
    }
}
