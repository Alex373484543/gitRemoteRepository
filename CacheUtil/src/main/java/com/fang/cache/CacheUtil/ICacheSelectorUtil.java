package com.fang.cache.CacheUtil;

import java.io.Serializable;

public interface ICacheSelectorUtil {

	boolean put(String cacheType, String cacheName, String key, Object value);

	Object get(String cacheType, String cacheName, String key);

	
}
