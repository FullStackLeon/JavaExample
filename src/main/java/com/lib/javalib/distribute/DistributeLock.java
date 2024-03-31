package com.lib.javalib.distribute;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import static java.lang.System.*;

public class DistributeLock {
    private static Jedis jedis;

    public static void main(String[] args) {
        jedis = new Jedis(new HostAndPort("localhost",6379));
        String key = "lock_key";
        String requestId = "123456";
        String result = jedis.set(key, requestId, SetParams.setParams().nx().ex(1800));
        if("OK".equals(result)) {
            out.println("lock successfully");
        } else out.println("lock failure");

        out.println("cache key value: " + jedis.get(key));
        out.println("cache key TTL: " + jedis.ttl(key));
        out.println(distributeDelLock(key,requestId));
    }

    private static Object distributeDelLock(String key, String requestId) {
        // 查询key的值是否和Value一致，如果一致将key删除，为解决加锁和解锁线程一致
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return nil end";
        return jedis.eval(script, 1, key, requestId);
    }
}
