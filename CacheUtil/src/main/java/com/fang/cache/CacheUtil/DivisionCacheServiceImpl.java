package com.fang.cache.CacheUtil;


import org.springframework.stereotype.Component;


@Component
public class DivisionCacheServiceImpl implements
		ICacheSelectorUtil {

	
	public boolean put(String cacheType, String cacheName, String key, Object value) {
		ICacheUtil supplierService = ObtainCacheServiceTool.getObtainSupplyService(cacheType);
		return supplierService.put(cacheName, key,value);
	}

	
	public  Object get(String cacheType,String cacheName, String key) {
		ICacheUtil supplierService = ObtainCacheServiceTool.getObtainSupplyService(cacheType);
		return supplierService.get(cacheName,key);
	}

	

}
