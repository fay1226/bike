package com.fay.bike.app.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author toyer
 * @date 2018-04-24
 */
@Component
@Slf4j
public class RedisResource {
    /** 一周 */
    private static final int EX_SECONDS = 60 * 60 * 24 * 7;

    public String getString(String key) {
        JedisPool pool = new JedisPool();
        try (Jedis jedis = pool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            log.error("获取缓存失败 key={}", key, e);
        }
        return null;
    }

    public void setString(String key, String value) {
        JedisPool pool = new JedisPool();
        try (Jedis jedis = pool.getResource()) {
            jedis.setex(key, RedisResource.EX_SECONDS, value);
        } catch (Exception e) {
            log.error("设置缓存失败 key={}", key, e);
        }
    }

    public void delString(String key) {
        JedisPool pool = new JedisPool();
        try (Jedis jedis = pool.getResource()) {
            jedis.del(key);
        } catch (Exception e) {
            log.error("清除缓存失败 key={}", key, e);
        }
    }
}
