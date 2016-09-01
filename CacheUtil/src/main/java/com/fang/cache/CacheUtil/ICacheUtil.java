package com.fang.cache.CacheUtil;



public interface ICacheUtil {


	public abstract boolean put(String cacheName, String key, Object value);

	public abstract Object get(String cacheName, String key);

	
}
