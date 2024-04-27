package com.lib.javalib.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ThreadLocalExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int userId = i;
            new Thread(() -> {
                String id = String.valueOf(userId);
                User user = new User("John" + id , 18 + userId);
                User.set(user.getName(), user);
                log.debug("Thread ID:{}, ThreadLocal value:{}", Thread.currentThread().getId(), User.get(user.getName()));
                log.debug("Thread ID:{}, Time:{}", Thread.currentThread().getId(),User.getSimpleDateFormat(null));
                User.removeUserByName(user.getName());
                User.remove();
            }).start();
        }
    }

}

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
    public static final ThreadLocal<Map<String,User>> USER_THREAD_LOCAL = new ThreadLocal<>();
    public static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void set(String name, User user) {
        if (USER_THREAD_LOCAL.get() == null) {
            USER_THREAD_LOCAL.set(new HashMap<>());
        }
        USER_THREAD_LOCAL.get().put(name, user);
    }
    public static User get(String name) {
        if (USER_THREAD_LOCAL.get() == null) {
            USER_THREAD_LOCAL.set(new HashMap<>());
        }
        return USER_THREAD_LOCAL.get().get(name);
    }

    public static void removeUserByName(String name) {
        if (USER_THREAD_LOCAL.get() == null) {
            return;
        }
        USER_THREAD_LOCAL.get().remove(name);
    }
    public static void remove() {
        USER_THREAD_LOCAL.get().clear();
        USER_THREAD_LOCAL.remove();
    }

    public static String getSimpleDateFormat(Long timestamp) {
        SimpleDateFormat simpleDateFormat = SIMPLE_DATE_FORMAT_THREAD_LOCAL.get();
        if (timestamp == null) {
            return simpleDateFormat.format(new Date());
        } else {
            return simpleDateFormat.format(new Date(timestamp));
        }
    }
}