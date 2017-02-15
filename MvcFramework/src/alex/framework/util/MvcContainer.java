package alex.framework.util;

import java.util.concurrent.ConcurrentHashMap;

public class MvcContainer {
	
	private static ConcurrentHashMap<Object, Object> map=new ConcurrentHashMap<Object, Object>();
	
	public static void add(Object key, Object value)
	{
		map.put(key, value);
	}
	
	public static boolean containKeys(Object key)
	{
		return map.containsKey(key);
	}
	
	
	public static void clear()
	{
		map.clear();
	}
	
	public static void remove(Object key)
	{
		map.remove(key);
	}
	
	public static Object get(Object key)
	{
		return map.get(key);
	}
	

}
