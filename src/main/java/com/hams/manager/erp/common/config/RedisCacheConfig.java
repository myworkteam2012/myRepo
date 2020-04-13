package com.hams.manager.erp.common.config;

import java.time.Duration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by wangl on 2017/11/25.
 * todo:
 */
@EnableCaching
@Configuration
public class RedisCacheConfig {

	 @SuppressWarnings("rawtypes")
	    @Bean
	    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
	     /*   RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
	                .entryTtl(null);
	        System.out.println("你的TTL："+defaultCacheConfig.getTtl());
	        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
	                .cacheDefaults(redisCacheConfiguration).build();*/
	    
	        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
	        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
			 defaultCacheConfig.entryTtl(Duration.ofDays(1));
	        
	        //////
	        System.out.println("你的TTL："+defaultCacheConfig.getTtl());
	        
	        
	        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
	        return cacheManager;
	 
	 }

	    @Bean
	    @SuppressWarnings({"rawtypes", "unchecked"})
	    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
	        RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();
	        redisTemplate.setConnectionFactory(connectionFactory);
	        //使用Jackson2JsonRedisSerializer替换默认的序列化规则
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
	        ObjectMapper objectMapper=new ObjectMapper();
	        objectMapper.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
	        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);


	        //设置value的序列化规则
	        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
	        //设置key的序列化规则
	        redisTemplate.setKeySerializer(new StringRedisSerializer());
	        redisTemplate.afterPropertiesSet();
	        return redisTemplate;
	    }

}
