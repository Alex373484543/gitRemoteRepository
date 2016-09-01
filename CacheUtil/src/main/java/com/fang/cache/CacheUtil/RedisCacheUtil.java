package com.fang.cache.CacheUtil;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



@Component("redisCache")
public class RedisCacheUtil implements ICacheUtil {

	private static Logger logger = Logger.getLogger(RedisCacheUtil.class);
	
	
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<Serializable, Object > redisTemplate;  

	
	@Resource(name = "redisTemplateRead")
	private RedisTemplate<Serializable, Object > redisTemplateRead;  

	
	public boolean put(String cacheName,final String key,final Object value) {
		redisTemplate.execute(new RedisCallback<Object>() {  
			public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {
            		 connection.set(
                        //��ע���ǰ׺��ʾ����ռ�  ����student.uid  
                        redisTemplate.getStringSerializer().serialize(  
                                "key.uid:"+key ),  
                        //��Ҫ���л����� 
                        SerializationUtil.writeObjectNonSet(value)
            		);
                    redisTemplate.expire("key.uid:"+key, 1, TimeUnit.DAYS);

                return true;  
            }
        });
		return false;
	}

	
	public Object get(String cacheName,final String key) {
		   return redisTemplateRead.execute(new RedisCallback<Object>() {  
	            public  Object doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                byte[] keyValue = redisTemplateRead.getStringSerializer().serialize(  
	                        "key.uid:" + key); 
	                if (connection.exists(keyValue)) {
	                    byte[] value = connection.get(keyValue);    
	                    System.out.println(value);
	                    //��redis��ȡ������Ҫ�����л�--- deserialize  
	                    Object obj =  SerializationUtil.deserializeNonSet(value);
	                  return  obj;    
	                }    
	            return null;  
	            }  
	        }); 
	}
}
