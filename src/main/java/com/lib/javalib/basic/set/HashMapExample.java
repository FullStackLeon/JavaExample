package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
            log.debug("after init,map key:{},value:{}", entry.getKey(),entry.getValue());
        }

        map.put(4,"d");
        map.forEach((key,value) -> log.debug("after add,map key:{},value:{}",key,value));

        map.remove(1);
        for (Integer key : map.keySet()) {
            log.debug("after remove,map key:{},value:{}", key, map.get(key));
        }
    }
}
