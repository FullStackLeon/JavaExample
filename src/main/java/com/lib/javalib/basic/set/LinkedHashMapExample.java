package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        for (Integer key : map.keySet()) {
            log.debug("after init,map key:{},value:{}", key, map.get(key));
        }

        map.put(4,"d");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            log.debug("after add,map key:{},value:{}",entry.getKey(),entry.getValue());
        }

        map.remove(1);
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer,String> entry = iterator.next();
            log.debug("after remove,map key:{},value:{}",entry.getKey(),entry.getValue());
        }
    }
}
