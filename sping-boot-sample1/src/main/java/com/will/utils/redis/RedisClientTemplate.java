package com.will.utils.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisCluster;

/**
 * 文件名：RedisClientTemplate.java
 * 描述：自定义redisTemplate
 * 作者：will
 * 日期：2017年9月28日上午11:11:56
 */
@Component
public class RedisClientTemplate {

	protected static Logger logger = LoggerFactory.getLogger(RedisClientTemplate.class);

	@Autowired
	private JedisCluster jedisCluster;
	@Autowired
	private RedisProperties redisProperties;
	/**用于隔开缓存前缀与缓存键值 */
	private static final String KEY_SPLIT = ":";

	/**
	 * 设置redis缓存
	 * @param prefix 缓存前缀
	 * @param key 缓存key
	 * @param value 缓存value
	 * 作者：will
	 * 日期：2017年9月28日上午11:19:58
	 */
	public void set(String prefix, String key, String value) {
		jedisCluster.set(prefix + KEY_SPLIT + key, value);
		logger.debug("设置redis缓存 key={},value={}", prefix + KEY_SPLIT + key, value);
	}

	/**
	 * 设置redis缓存并指定过期时间
	 * @param prefix 缓存前缀
	 * @param key 缓存key
	 * @param value 缓存value
	 * 作者：will
	 * 日期：2017年9月28日上午11:19:58
	 */
	public void setWithExpireTime(String prefix, String key, String value, int expireTime) {
		jedisCluster.setex(prefix + KEY_SPLIT + key, expireTime, value);
		logger.debug("设置redis缓存并指定失效时间 key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value, expireTime);
	}

	/**
	 * 获取指定key的缓存
	 * @param prefix 缓存前缀
	 * @param key 缓存key
	 * @return
	 * 作者：will
	 * 日期：2017年9月28日上午11:24:33
	 */
	public String get(String prefix, String key) {
		String value = jedisCluster.get(prefix + KEY_SPLIT + key);
		logger.debug("获取redis缓存 key={},value={}", prefix + KEY_SPLIT + key, value);
		return value;
	}

	/**
	 * 删除指定缓存
	 * @param prefix 缓存前缀
	 * @param key 缓存key
	 * 作者：will
	 * 日期：2017年9月28日上午11:25:20
	 */
	public void deleteWithPrefix(String prefix, String key) {
		jedisCluster.del(prefix + KEY_SPLIT + key);
		logger.debug("删除redis缓存 key={}", prefix + KEY_SPLIT + key);
	}

}
