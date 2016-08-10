package fanglab.framework.protocol;

import java.text.*;
import java.util.*;

/**
 * 搜索协议
 * 
 */
public class SlSearchProtocol {
	private static String safe(String input) {
		return input.replace(":", "").replace("』", "").replace(",", "")
				.replace("|", "");
	}

	/**
	 * 格式化创建或更新索引
	 * 
	 * @param version
	 *            ，版本
	 * @param dir
	 *            ，相对目录
	 * @param fields
	 *            ，字段
	 * @return，结果
	 */
	public static String formatCreateOrUpdateIndexRequest(String version,
			String dir, HashMap<String, String> fields) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』",
				"CreateOrUpdateIndexRequest"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "』", safe(dir)));
		String temp = "";
		for (String key : fields.keySet()) {
			String value = fields.get(key);
			temp = temp + String.format("%s,%s", safe(key), safe(value)) + "|";
		}
		temp = temp.substring(0, temp.length() - 1);

		result.append(String.format("fields:%s" + "』", temp));
		return result.toString();
	}

	/**
	 * 格式化创建或更新索引
	 * 
	 * @param version
	 *            ，版本
	 * @param state
	 *            ，状态
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static String formatCreateOrUpdateIndexResponse(String version,
			String state, String message) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』",
				"CreateOrUpdateIndexResponse"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "』", safe(state)));
		result.append(String.format("message:%s" + "』", safe(message)));
		return result.toString();
	}

	/**
	 * 解析创建或更新索引
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseCreateOrUpdateIndexRequest(
			String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 解析
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 解析创建或更新索引
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseCreateOrUpdateIndexResponse(
			String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 格式化搜索
	 * 
	 * @param version
	 *            ，版本
	 * @param dir
	 *            ，相对目录
	 * @param keyword
	 *            ，关键字
	 * @param searchfields
	 *            ，查询字段
	 * @param resultfields
	 *            ，结果字段
	 * @param take
	 *            ，取多少行
	 * @return，结果
	 */
	public static String formatSearchRequest(String version, String dir,
			String keyword, String[] searchfields, String[] resultfields,
			int take) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』", "SearchRequest"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "』", safe(dir)));
		result.append(String.format("take:%s" + "』", String.valueOf(take)));
		result.append(String.format("keyword:%s" + "』", safe(keyword)));
		{
			String temp = "";
			for (String field : searchfields) {
				temp = temp + field + "|";
			}
			temp = temp.substring(0, temp.length() - 1);
			result.append(String.format("searchfields:%s" + "』", temp));
		}
		{
			String temp = "";
			for (String field : resultfields) {
				temp = temp + field + "|";
			}
			temp = temp.substring(0, temp.length() - 1);
			result.append(String.format("resultfields:%s" + "』", temp));
		}
		return result.toString();
	}

	/**
	 * 格式化搜索
	 * 
	 * @param version
	 *            ，版本
	 * @param dir
	 *            ，相对目录
	 * @param keyword
	 *            ，关键字
	 * @param fields
	 *            ，查询字段
	 * @return，结果
	 */
	public static String formatSearchResponse(String version, String state,
			String message, int count) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』", "SearchResponse"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "』", safe(state)));
		result.append(String.format("message:%s" + "』", safe(message)));
		result.append(String.format("count:%s" + "』", String.valueOf(count)));
		return result.toString();
	}

	/**
	 * 解析搜索
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseSearchRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 解析搜索
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseSearchResponse(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}
	/**
	 * 格式化删除
	 * 
	 * @param version
	 *            ，版本
	 * @param dir
	 *            ，相对目录
	 * @return，结果
	 */
	public static String formatDeleteRequest(String version, String dir) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』", "DeleteRequest"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "』", safe(dir)));
		return result.toString();
	}

	/**
	 * 格式化删除
	 * 
	 * @param version
	 *            ，版本
	 * @param dir
	 *            ，相对目录
	 * @return，结果
	 */
	public static String formatDeleteResponse(String version, String state,
			String message) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "』", safe(version)));
		result.append(String.format("operate:%s" + "』", "DeleteResponse"));
		result.append(String.format("time:%s" + "』", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "』", safe(state)));
		result.append(String.format("message:%s" + "』", safe(message)));
		return result.toString();
	}

	/**
	 * 解析搜索
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseDeleteRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 解析搜索
	 * 
	 * @param message
	 *            ，消息
	 * @return，结果
	 */
	public static HashMap<String, String> parseDeleteResponse(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("』");
		for (int i = 0; i < kvs.length; i++) {
			String[] kv = kvs[i].split("\\:");
			if (kv.length == 2) {
				String key = kv[0];
				String value = kv[1];
				result.put(key, value);
			}
		}
		return result;
	}
}
