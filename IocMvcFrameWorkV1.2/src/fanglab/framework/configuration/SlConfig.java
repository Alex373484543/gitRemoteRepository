package fanglab.framework.configuration;

import java.text.*;
import java.util.*;

import org.apache.commons.lang3.*;

import fanglab.framework.*;
import fanglab.framework.diagnostics.*;

/*
 * ����
 */
public class SlConfig {
	/*
	 * ��������
	 * 
	 * @param String value������
	 * 
	 * @return String�����
	 */
	public static String parseVariable(String value) {
		String result = value;
		result = result
				.replace("@(SlDateTime.nowTime())", SlDateTime.nowTime());
		result = result
				.replace("@(SlDateTime.nowDate())", SlDateTime.nowDate());
		result = result.replace("@(SlDateTime.now())", SlDateTime.now());
		result = result
				.replace("@(SlDateTime.nowYear())", SlDateTime.nowYear());
		result = result.replace("@(SlDateTime.nowMonth())",
				SlDateTime.nowMonth());
		result = result.replace("@(SlDateTime.nowDay())", SlDateTime.nowDay());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		result = result.replace("@(SlAppContext.StartupTime)",
				simpleDateFormat.format(SlAppContext.StartupTime));
		result = result.replace("@(SlAppContext.Directory)",
				SlAppContext.Directory);
		result = result.replace("@(SlAppContext.LogFilePath)",
				SlAppContext.LogFilePath);
		result = result.replace("@(SlGuid.NewGuid())", SlGuid.newGuid());
		return result;
	}

	/*
	 * ����Ϊ����
	 * 
	 * @param String value��ֵ
	 * 
	 * @param String split���ָ��
	 * 
	 * @param boolean isDecode���Ƿ����
	 */
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> parseArray(String value, String split,
			boolean isDecode) {
		if (isDecode) {
			value = StringEscapeUtils.unescapeHtml4(value);
		}
		ArrayList<T> list = new ArrayList<T>();
		if (!(value == null || value.trim().isEmpty())) {
			String[] values = value.split(split);
			for (String one : values) {
				list.add((T) one);
			}
		}
		return list;
	}

	/*
	 * ����Ϊ����
	 * 
	 * @param String value��ֵ
	 * 
	 * @param String split���ָ��
	 * 
	 * @param boolean isDecode���Ƿ����
	 */
	public static <T> ArrayList<T> parseArray(String value, String split) {
		return parseArray(value, split, true);
	}

	/*
	 * ����Ϊ����
	 * 
	 * @param String value��ֵ
	 * 
	 * @param String split���ָ��
	 * 
	 * @param boolean isDecode���Ƿ����
	 */
	public static <T> ArrayList<T> parseArray(String value) {
		return parseArray(value, "\\|", true);
	}
}
