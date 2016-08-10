package fanglab.framework.web;

import net.sf.json.*;

/*
 * Json格式数据处理
 */
public class SlJson {
	/*
	 * 将对象序列化为Json格式的字符串
	 * 
	 * @param Object source，源类型对象
	 * 
	 * @return String，Json格式的字符串
	 */
	public static String toJson(Object source) {
		return JSONObject.fromObject(source).toString();
	}

	/*
	 * 将Json格式的数据转换为对象
	 * 
	 * @param String json，json格式的字符串
	 * 
	 * @return Object，序列化之后的格式
	 */
	@SuppressWarnings("rawtypes")
	public static Object fromJson(String json, Class beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return JSONObject.toBean(jsonObject, beanClass);
	}

	/*
	 * 判断是否相等
	 * 
	 * @param Object a，a
	 * 
	 * @param Object b，b
	 * 
	 * @return boolean，结果
	 */
	public static boolean jsonEquals(Object a, Object b) {
		return toJson(a).equals(toJson(b));
	}

	/*
	 * 获得安全字符串
	 * 
	 * @param String input，输入
	 * 
	 * @return String，结果
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
