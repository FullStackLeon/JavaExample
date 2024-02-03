package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        for (int i = 0; i < map.size(); i++) {
            log.debug("after init, map key:{},value:{}",i,map.get(i));
        }

        map.put(4,"d");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            log.debug("after add,map key:{},value:{}",entry.getKey(),entry.getValue());
        }

        map.remove(1);
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            log.debug("after remove,map key:{},value:{}",entry.getKey(),entry.getValue());
        }
    }
}
