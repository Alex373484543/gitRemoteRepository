package fanglab.framework;

import java.util.*;

public class SlContainer {
	private static Object syncObject = new Object();

	private static HashMap<Object, Object> container;

	/*
	 * 静态构造函数
	 */
	static {
		container = new HashMap<Object, Object>();
	}

	/*
	 * 增加键值对
	 * 
	 * @param Object key，键
	 * 
	 * @param Object value，值
	 */
	public static void add(Object key, Object value) {
		synchronized (syncObject) {
			container.put(key, value);
		}
	}

	/*
	 * 是否包含
	 * 
	 * @param Object key，键
	 * 
	 * @return boolean，结果
	 */
	public static boolean containsKey(Object key) {
		return container.containsKey(key);
	}

	/*
	 * 清空容器
	 */
	public static void clear() {
		synchronized (syncObject) {
			container.clear();
		}
	}

	/*
	 * 是否包含
	 * 
	 * @param Object key，键
	 */
	public static void remove(Object key) {
		synchronized (syncObject) {
			container.remove(key);
		}
	}

	/*
	 * 获取
	 * 
	 * @param Object key，键
	 * 
	 * @return Object，值
	 */
	public static Object get(Object key) {
		return container.get(key);
	}

	/*
	 * 设置
	 * 
	 * @param Object key，键
	 * 
	 * @param Object value，值
	 */
	public static void set(Object key, Object value) {
		synchronized (syncObject) {
			container.put(key, value);
		}
	}
}
