package com.ecdatainfo.wechat.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Component
public class RedisManager {

    @Autowired
    private JedisPool jedisPool ;


    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * Get value from Redis
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = jedisPool.getResource();

        try {
            return jedis.get(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * Set value into Redis with default time to live in seconds.
     * @param key
     * @param value
     */
    public void set(String key, String value){
        Jedis jedis = jedisPool.getResource();

        try {
            jedis.set(key, value);
        } finally {
            jedis.close();
        }
    }

    /**
     * Set value into Redis with specified time to live in seconds.
     * @param key
     * @param value
     * @param timeToLiveSeconds
     */
    public void setex(String key, String value, int timeToLiveSeconds){
        Jedis jedis = jedisPool.getResource();

        try {
            jedis.setex(key, timeToLiveSeconds, value);
        } finally {
            jedis.close();
        }
    }

    /**
     * Delete key and its value from Jedis.
     * @param key
     */
    public void del(String key){
        Jedis jedis = jedisPool.getResource();

        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    /**
     * Get keys matches the given pattern.
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.keys(pattern);
        } finally {
            jedis.close();
        }
    }

    /**
     * Get multiple values for the given keys.
     * @param keys
     * @return
     */
    public Collection<String> mget(String... keys) {
        if (keys == null && keys.length == 0) {
            Collections.emptySet();
        }

        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.mget(keys);
        } finally {
            jedis.close();
        }
    }

    /**
     * Publish message to channel using subscribe and publish protocol.
     * @param channel
     * @param value
     */
    public void publish(String channel, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.publish(channel, value);
        } finally {
            jedis.close();
        }
    }
}