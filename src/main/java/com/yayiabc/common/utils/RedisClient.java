package com.yayiabc.common.utils;

import com.yayiabc.http.mvc.expand.KeyExpiredListener;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by 小月亮 on 2017/8/27.
 */
public class RedisClient {
    private static final String ip= "47.93.48.111";

    private static final int port=6379;

    protected static RedisClient redis = new RedisClient ();

    public final static Jedis jedis = new Jedis( ip, port);
  
    static {
    	
    }

    protected RedisClient() {
    	
    }

    public static RedisClient getInstance()

    {
        return redis;
    }



    /**set Object*/

    public String set(Object object,String key)

    {

        return jedis.set(key.getBytes(), SerializeUtil.serialize(object));

    }



    /**get Object*/

    public Object get(String key)

    {

        byte[] value = jedis.get(key.getBytes());

        return SerializeUtil. unserialize(value);

    }



    /**delete a key**/

    public boolean del(String key)

    {

        return jedis.del(key.getBytes())>0;

    }

}