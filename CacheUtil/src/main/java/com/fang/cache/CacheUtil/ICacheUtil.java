package com.fang.cache.CacheUtil;

/**
 * 
 * @author 王超
 *
 *抽象策略类
 */

public interface ICacheUtil {


	public abstract boolean put(String cacheName, String key, Object value);

	public abstract Object get(String cacheName, String key);

	
}
