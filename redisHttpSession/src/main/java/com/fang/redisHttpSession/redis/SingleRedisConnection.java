package com.fang.redisHttpSession.redis;



import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.SerializationUtils;

import redis.clients.jedis.Jedis;

/**
 * Created by xhans on 2016/4/28.
 */
public class SingleRedisConnection implements RedisConnection {

    private Jedis jedis;

    public SingleRedisConnection(Jedis jedis) {
        this.jedis = jedis;
    }

  
    public void close() {
        jedis.close();
    }

   
    public Boolean isConnected() {
        return jedis.isConnected();
    }

   
    public Long hset(String key, String field, Serializable object) {
        return jedis.hset(key.getBytes(),
                field.getBytes(),
                SerializationUtils.serialize(object));
    }

   
    public Object hget(String key, String field) {
        byte[] bytes = jedis.hget(key.getBytes(), field.getBytes());
        if (bytes == null){
            return null;
        } else {
            return SerializationUtils.deserialize(bytes);
        }
    }

   
    public Long del(String... keys) {
        return jedis.del(keys);
    }

   
    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }

  
    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

   
    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }

   
    public Boolean exists(String key) {
        return jedis.exists(key);
    }
}
