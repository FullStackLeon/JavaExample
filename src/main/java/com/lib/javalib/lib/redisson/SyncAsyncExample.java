package com.lib.javalib.lib.redisson;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.System.*;

public class SyncAsyncExample {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);

        // string 类型操作示例
        RBucket<String> stringObj = redissonClient.getBucket("key1");
        stringObj.delete();
        stringObj.set("value1");
        out.println(stringObj.get());

        // hash 类型操作示例
        RMap<String, String> hashMapObj = redissonClient.getMap("mapKey1");
        hashMapObj.clear();
        hashMapObj.put("key1","value1");
        hashMapObj.put("key2","value2");
        out.println(hashMapObj.readAllMap());
        Set<String> keys = new HashSet<>();
        keys.add("key1");
        keys.add("key2");
        Map<String, String> mapValue = hashMapObj.getAll(keys);
        out.println(mapValue);

        // list 类型操作示例
        RList<String> listObj = redissonClient.getList("listKey1");
        listObj.clear();
        listObj.add("value1");
        listObj.add("value2");
        out.println(listObj.readAll());

        // set 类型操作示例
        RSet<String> setObj = redissonClient.getSet("setKey1");
        setObj.clear();
        setObj.add("value1");
        setObj.add("value2");
        out.println(setObj.readAll());

        // zset 类型操作示例
        RScoredSortedSet<String> sortedSetObj = redissonClient.getScoredSortedSet("sortedSetKey1");
        sortedSetObj.clear();
        sortedSetObj.add(1, "value1");
        sortedSetObj.add(2, "value2");
        out.println(sortedSetObj.readAll());

        // 分布式锁示例
        RLock lock = redissonClient.getLock("distributed_lock");
        try {
            if (lock.tryLock()) {
                out.println("try lock successfully");
            } else {
                out.println("try lock failure");
            }
        } finally {
            lock.unlock();
        }

        redissonClient.shutdown();
    }
}
