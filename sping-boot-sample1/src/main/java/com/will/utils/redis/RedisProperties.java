package com.will.utils.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 文件名：RedisProperties.java
 * 描述：redis集群配置文件
 * 作者：will
 * 日期：2017年9月28日上午10:51:08
 */
@Component
@ConfigurationProperties(prefix = "redis.cache")
@PropertySource("classpath:application.properties")
public class RedisProperties {

	/**redis集群节点*/
	private String clusterNodes;

	/**连接超时时间*/
	private Integer commandTimeout;

	/**重连次数*/
	private Integer expireSeconds;

	public String getClusterNodes() {
		return clusterNodes;
	}

	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}

	public Integer getCommandTimeout() {
		return commandTimeout;
	}

	public void setCommandTimeout(Integer commandTimeout) {
		this.commandTimeout = commandTimeout;
	}

	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
}
