package fanglab.framework.protocol;

import java.text.*;
import java.util.*;

/**
 * ����Э��
 * 
 */
public class SlSearchProtocol {
	private static String safe(String input) {
		return input.replace(":", "").replace("��", "").replace(",", "")
				.replace("|", "");
	}

	/**
	 * ��ʽ���������������
	 * 
	 * @param version
	 *            ���汾
	 * @param dir
	 *            �����Ŀ¼
	 * @param fields
	 *            ���ֶ�
	 * @return�����
	 */
	public static String formatCreateOrUpdateIndexRequest(String version,
			String dir, HashMap<String, String> fields) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��",
				"CreateOrUpdateIndexRequest"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "��", safe(dir)));
		String temp = "";
		for (String key : fields.keySet()) {
			String value = fields.get(key);
			temp = temp + String.format("%s,%s", safe(key), safe(value)) + "|";
		}
		temp = temp.substring(0, temp.length() - 1);

		result.append(String.format("fields:%s" + "��", temp));
		return result.toString();
	}

	/**
	 * ��ʽ���������������
	 * 
	 * @param version
	 *            ���汾
	 * @param state
	 *            ��״̬
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static String formatCreateOrUpdateIndexResponse(String version,
			String state, String message) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��",
				"CreateOrUpdateIndexResponse"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "��", safe(state)));
		result.append(String.format("message:%s" + "��", safe(message)));
		return result.toString();
	}

	/**
	 * �����������������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseCreateOrUpdateIndexRequest(
			String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * ����
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * �����������������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseCreateOrUpdateIndexResponse(
			String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * ��ʽ������
	 * 
	 * @param version
	 *            ���汾
	 * @param dir
	 *            �����Ŀ¼
	 * @param keyword
	 *            ���ؼ���
	 * @param searchfields
	 *            ����ѯ�ֶ�
	 * @param resultfields
	 *            ������ֶ�
	 * @param take
	 *            ��ȡ������
	 * @return�����
	 */
	public static String formatSearchRequest(String version, String dir,
			String keyword, String[] searchfields, String[] resultfields,
			int take) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��", "SearchRequest"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "��", safe(dir)));
		result.append(String.format("take:%s" + "��", String.valueOf(take)));
		result.append(String.format("keyword:%s" + "��", safe(keyword)));
		{
			String temp = "";
			for (String field : searchfields) {
				temp = temp + field + "|";
			}
			temp = temp.substring(0, temp.length() - 1);
			result.append(String.format("searchfields:%s" + "��", temp));
		}
		{
			String temp = "";
			for (String field : resultfields) {
				temp = temp + field + "|";
			}
			temp = temp.substring(0, temp.length() - 1);
			result.append(String.format("resultfields:%s" + "��", temp));
		}
		return result.toString();
	}

	/**
	 * ��ʽ������
	 * 
	 * @param version
	 *            ���汾
	 * @param dir
	 *            �����Ŀ¼
	 * @param keyword
	 *            ���ؼ���
	 * @param fields
	 *            ����ѯ�ֶ�
	 * @return�����
	 */
	public static String formatSearchResponse(String version, String state,
			String message, int count) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��", "SearchResponse"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "��", safe(state)));
		result.append(String.format("message:%s" + "��", safe(message)));
		result.append(String.format("count:%s" + "��", String.valueOf(count)));
		return result.toString();
	}

	/**
	 * ��������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseSearchRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * ��������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseSearchResponse(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * ��ʽ��ɾ��
	 * 
	 * @param version
	 *            ���汾
	 * @param dir
	 *            �����Ŀ¼
	 * @return�����
	 */
	public static String formatDeleteRequest(String version, String dir) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��", "DeleteRequest"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("dir:%s" + "��", safe(dir)));
		return result.toString();
	}

	/**
	 * ��ʽ��ɾ��
	 * 
	 * @param version
	 *            ���汾
	 * @param dir
	 *            �����Ŀ¼
	 * @return�����
	 */
	public static String formatDeleteResponse(String version, String state,
			String message) {
		StringBuilder result = new StringBuilder();
		result.append(String.format("version:%s" + "��", safe(version)));
		result.append(String.format("operate:%s" + "��", "DeleteResponse"));
		result.append(String.format("time:%s" + "��", new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS").format(new Date())));
		result.append(String.format("state:%s" + "��", safe(state)));
		result.append(String.format("message:%s" + "��", safe(message)));
		return result.toString();
	}

	/**
	 * ��������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseDeleteRequest(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
	 * ��������
	 * 
	 * @param message
	 *            ����Ϣ
	 * @return�����
	 */
	public static HashMap<String, String> parseDeleteResponse(String message) {
		HashMap<String, String> result = new HashMap<String, String>();
		String[] kvs = message.split("��");
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
