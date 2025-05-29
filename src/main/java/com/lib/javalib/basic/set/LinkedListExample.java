package com.lib.javalib.basic.set;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (int i = 0; i < list.size(); i++) {
            log.debug("after init,list item:{}", list.get(i));
        }

        list.add("d");
        for(String item:list){
            log.debug("after add,list item:{}", item);
        }

        list.set(0, "abc");
        for (int i = 0; i < list.size(); i++) {
            log.debug("after set,list item:{}", list.get(i));
        }
        list.remove("d");
        for (String item:list){
            log.debug("after remove,list item:{}", item);
        }
        list.pop();
        for (String item:list){
            log.debug("after set and remove,list item:{}", item);
        }
    }
}
