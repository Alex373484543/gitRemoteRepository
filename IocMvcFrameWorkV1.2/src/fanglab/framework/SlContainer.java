package fanglab.framework;

import java.util.*;

public class SlContainer {
	private static Object syncObject = new Object();

	private static HashMap<Object, Object> container;

	/*
	 * ��̬���캯��
	 */
	static {
		container = new HashMap<Object, Object>();
	}

	/*
	 * ���Ӽ�ֵ��
	 * 
	 * @param Object key����
	 * 
	 * @param Object value��ֵ
	 */
	public static void add(Object key, Object value) {
		synchronized (syncObject) {
			container.put(key, value);
		}
	}

	/*
	 * �Ƿ����
	 * 
	 * @param Object key����
	 * 
	 * @return boolean�����
	 */
	public static boolean containsKey(Object key) {
		return container.containsKey(key);
	}

	/*
	 * �������
	 */
	public static void clear() {
		synchronized (syncObject) {
			container.clear();
		}
	}

	/*
	 * �Ƿ����
	 * 
	 * @param Object key����
	 */
	public static void remove(Object key) {
		synchronized (syncObject) {
			container.remove(key);
		}
	}

	/*
	 * ��ȡ
	 * 
	 * @param Object key����
	 * 
	 * @return Object��ֵ
	 */
	public static Object get(Object key) {
		return container.get(key);
	}

	/*
	 * ����
	 * 
	 * @param Object key����
	 * 
	 * @param Object value��ֵ
	 */
	public static void set(Object key, Object value) {
		synchronized (syncObject) {
			container.put(key, value);
		}
	}
}
