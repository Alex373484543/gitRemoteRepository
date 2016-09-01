package com.fang.cache.CacheUtil;


import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Íõ³¬
 * 
 * Aop
 *
 */

@Aspect
@Component
public class CacheInterceptor {
//	private static Log logger = LogFactory.getLog(CacheInterceptor.class);	
	
	private static Logger logger = Logger.getLogger(CacheInterceptor.class);
	
	@Autowired
	ICacheSelectorUtil cache ;
	
	@Around("@annotation(enabledCache)")
	public  Object doBasicProfiling(ProceedingJoinPoint pjp, Cacheable enabledCache) throws Throwable {
		if(cache.get(enabledCache.type(),enabledCache.key(),Arrays.toString(pjp.getArgs())) != null){
			logger.info("get content from cache, cachename = " + enabledCache.key() + ", cachekey = "+Arrays.toString(pjp.getArgs()));
			return cache.get(enabledCache.type(),enabledCache.key(),Arrays.toString(pjp.getArgs()));
		}
		Object object = pjp.proceed();
		if(object != null){
			logger.info("put content to cache, cachename = " + enabledCache.key() + ", cachekey = "+Arrays.toString(pjp.getArgs()));
			cache.put(enabledCache.type(),enabledCache.key(), Arrays.toString(pjp.getArgs()),object);
		}
		return object;
	}
}
