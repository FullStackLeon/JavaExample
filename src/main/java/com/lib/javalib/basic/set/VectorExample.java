package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
public class VectorExample {
    public static void main(String[] args) {
        Vector<String> list = new Vector<>();
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
        list.remove("d");
        for (String item:list){
            log.debug("after set and remove,list item:{}", item);
        }
    }
}
