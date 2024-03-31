package com.lib.javalib.distribute;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import static java.lang.System.*;

public class DistributeLockWithWatchDog {
    private final Jedis jedis;
    private final String key;
    private final String requestId;
    private final int expireTime;

    private Thread watchDog;

    public static void main(String[] args) throws InterruptedException {
        DistributeLockWithWatchDog distributeLockWithWatchDog = new DistributeLockWithWatchDog("lock_key","123456", 10000);

        boolean lockResult = distributeLockWithWatchDog.lock();
        if(lockResult) {
            out.println("lock successfully");
        } else {
            out.println("lock failure");
        }

        Thread.sleep(10000);
        boolean unlockResult = distributeLockWithWatchDog.unlock();
        if(unlockResult) {
            out.println("unlock successfully");
        } else {
            out.println("unlock failure");
        }
    }

    public DistributeLockWithWatchDog(String key, String requestId, int expireTime) {
        this.key = key;
        this.requestId = requestId;
        this.expireTime = expireTime;
        this.jedis = new Jedis(new HostAndPort("localhost",6379));
    }

    private boolean lock() {
        String result = this.jedis.set(this.key, this.requestId, SetParams.setParams().nx().ex(this.expireTime));
        // 当加锁成功时，启动watchdog线程给lock定时续期
        if("OK".equals(result)) {
            startWatchDog();
            return true;
        }
        return false;
    }

    private boolean unlock() {
        // 成功删除lock时，停止watchdog
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return nil end";
        Object object = this.jedis.eval(script, 1, this.key, this.requestId);
        if(Long.valueOf(1L).equals(object)) {
            stopWatchDog();
            return true;
        }
        return false;
    }

    private void startWatchDog() {
        // 通过Lambda表达式创建线程实现watchdog,等待过期时间一半就给lock续期
        this.watchDog = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(this.expireTime / 2);
                    this.jedis.expire(key, this.expireTime / 1000);
                    out.println("watchDog is running, key ttl:" + this.jedis.ttl(this.key));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        this.watchDog.start();
    }

    private void stopWatchDog() {
        if(this.watchDog != null) {
            this.watchDog.interrupt();
        }
    }
}
