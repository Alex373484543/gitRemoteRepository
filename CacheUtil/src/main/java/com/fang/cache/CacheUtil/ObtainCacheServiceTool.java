package com.fang.cache.CacheUtil;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ObtainCacheServiceTool {

	private static ObtainCacheServiceTool obtainCacheServiceTool = null;

	// ehcache
	@Resource(name = "cache")
	private ICacheUtil cache;
	
	@Resource(name = "redisCache")
	private ICacheUtil redisCache;

	@PostConstruct
	public void init() {
		obtainCacheServiceTool = this;
		obtainCacheServiceTool.cache = this.cache;
	}

	public static ICacheUtil getObtainSupplyService(String cacheType) {
		if (CacheConstants.CacheType.ECHACHED.equals(cacheType)) {
			return obtainCacheServiceTool.cache;
		} else if (CacheConstants.CacheType.REDISHED.equals(cacheType)){

			return obtainCacheServiceTool.redisCache;
		}

		 return obtainCacheServiceTool.cache;
	}

}
