package com.fang.cache.CacheUtil;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;



@Component("cache")
public class EhCacheUtil implements ICacheUtil{
	private static Logger logger = Logger.getLogger(EhCacheUtil.class);
	
	
	@Autowired
	private CacheManager cacheManager;
	

	
	
	
	/**
	 * ���cacheName �� key����ȡ����
	 * @param cacheName
	 * @param key
	 * @return
	 */

	public Object get(final String cacheName,final String key) {
    	
    		Cache cache = cacheManager.getCache(cacheName);
    		if(cache == null){
    			logger.error("do not have this cache,cacheName=" + cacheName + ",key=" + key);
    			return null;
    		}
    		Object obj = cache.get(key);
    		if (obj == null) {
    			return null;
    		}
    		return (Object) cache.get(key).get();
    
	}

	public boolean put(final String cacheName, final String key,final Object value) {
    	
    		Cache cache = cacheManager.getCache(cacheName);
    		if(cache == null){
    			return false;
    		}
    		cache.put(key, value);
        		return true;
    	
    }
    
    
    
}
