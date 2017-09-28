package com.will.utils.redis;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * 文件名：JedisClusterConfig.java
 * 描述：生成JedisCluster对象
 * 作者：will
 * 日期：2017年9月28日上午11:06:26
 */
@Configuration
public class JedisClusterConfig {

	@Autowired
	private RedisProperties redisProperties;

	/**
	 * 返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用  
	 * @return
	 * 作者：王承
	 * 日期：2017年9月28日上午11:10:29
	 */
	@Bean
	public JedisCluster getJedisCluster() {
		String[] serverArray = redisProperties.getClusterNodes().split(",");// 获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
		Set<HostAndPort> nodes = new HashSet<>();

		for (String ipPort : serverArray) {
			String[] ipPortPair = ipPort.split(":");
			nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
		}
		return new JedisCluster(nodes, redisProperties.getCommandTimeout(), redisProperties.getExpireSeconds());
	}

}
