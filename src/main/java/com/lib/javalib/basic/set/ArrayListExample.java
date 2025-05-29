package com.lib.javalib.basic.set;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

@Slf4j
public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String s : list) {
            log.debug("after init,list item: " + s);
        }

        list.add("5");
        for(int i = 0; i < list.size(); i++) {
            log.debug("after add,list item: " + list.get(i));
        }

        list.removeAll(Collections.singleton("5"));
        list.set(0, "12345");
        for (String s : list) {
            log.debug("after remove and set,list item: " + s);
        }
        list.remove(0);
        for (String s : list) {
            log.debug("after remove,list item: " + s);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (Integer.parseInt(s) % 2 == 0) {
                iterator.remove();
            }
        }
        for (String s : list) {
            log.debug("after iterator remove,list item: " + s);
        }
    }
}
