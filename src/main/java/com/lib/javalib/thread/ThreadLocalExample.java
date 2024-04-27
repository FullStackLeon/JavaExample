package com.lib.javalib.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
                log.debug("Thead ID:{}, ThreadLocal value:{}", Thread.currentThread().getId(), User.get(user.getName()));
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
}