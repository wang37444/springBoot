package com.will.shedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.will.utils.redis.RedisClientTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpingBootSample1ApplicationTests {

	protected static Logger logger = LoggerFactory.getLogger(RedisClientTemplate.class);

	@Autowired
	RedisClientTemplate redisClientTemplate;

	/**
	 * redis测试方法
	 * 
	 * 作者：will
	 * 日期：2017年9月28日下午3:52:40
	 */
	@Test
	public void testRedis() {
		redisClientTemplate.setWithExpireTime("user", "01", "will", 60);
		String str = redisClientTemplate.get("user", "01");
		logger.info("redis缓存信息：" + str);
	}

}
