package com.ecdatainfo.wechat.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {


    @Value("${spring.redis.sessionDatabase}")
    private Integer sessionDatabase;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.pool.max_active}")
    private Integer max_active;

    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.pool.max_wait}")
    private Integer max_wait;


    @Value("${spring.redis.pool.max_total}")
    private Integer max_total;
    @Value("${spring.redis.pool.max_wait_millis}")
    private Long max_wait_millis;
    @Value("${spring.redis.pool.test_on_borrow}")
    private Boolean test_on_borrow;
    @Value("${spring.redis.pool.max_idle}")
    private  Integer max_idle;
    @Value("${spring.redis.pool.min_idle}")
    private Integer min_idle;


    @Bean(name="jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(max_idle);
        jedisPoolConfig.setMaxWaitMillis(max_wait_millis);
        jedisPoolConfig.setMaxTotal(max_total);
        jedisPoolConfig.setTestOnBorrow(test_on_borrow);
        jedisPoolConfig.setMinIdle(min_idle);
        return  jedisPoolConfig;
    }

    @Bean(name="jedisPool")
    public JedisPool jedisPool(){
        JedisPool jedisPool =
                new JedisPool(jedisPoolConfig(),host,port,timeout,password,sessionDatabase);
        return jedisPool;
    }



	
}
