package fanglab.framework.web;

import net.sf.json.*;

/*
 * Json��ʽ���ݴ���
 */
public class SlJson {
	/*
	 * ���������л�ΪJson��ʽ���ַ���
	 * 
	 * @param Object source��Դ���Ͷ���
	 * 
	 * @return String��Json��ʽ���ַ���
	 */
	public static String toJson(Object source) {
		return JSONObject.fromObject(source).toString();
	}

	/*
	 * ��Json��ʽ������ת��Ϊ����
	 * 
	 * @param String json��json��ʽ���ַ���
	 * 
	 * @return Object�����л�֮��ĸ�ʽ
	 */
	@SuppressWarnings("rawtypes")
	public static Object fromJson(String json, Class beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return JSONObject.toBean(jsonObject, beanClass);
	}

	/*
	 * �ж��Ƿ����
	 * 
	 * @param Object a��a
	 * 
	 * @param Object b��b
	 * 
	 * @return boolean�����
	 */
	public static boolean jsonEquals(Object a, Object b) {
		return toJson(a).equals(toJson(b));
	}

	/*
	 * ��ð�ȫ�ַ���
	 * 
	 * @param String input������
	 * 
	 * @return String�����
	 */
	@SuppressWarnings("unchecked")
	public static String getSafeJson(String input) {
		if (input == null || input.isEmpty()) {
			return "";
		}

		SlJsonWarp<String> jsonWarp = new SlJsonWarp<String>();
		jsonWarp.setValue(input);

		return ((SlJsonWarp<String>) fromJson(toJson(jsonWarp),
				jsonWarp.getClass())).getValue();
	}

	public static class SlJsonWarp<T> {
		private T value;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}
	}
}
