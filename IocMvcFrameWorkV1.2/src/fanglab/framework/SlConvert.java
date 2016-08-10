package fanglab.framework;

import java.text.SimpleDateFormat;
import java.util.*;


/*
 * 转换类
 */
public class SlConvert {

	/*
	 * 解析为数组
	 * 
	 * @param String value，值
	 * 
	 * @param String split，分割符
	 */
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> parseArray(String value, String split) {
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
	 * 解析为数组
	 * 
	 * @param String value，值
	 * 
	 * @param String split，分割符
	 */
	public static <T> ArrayList<T> parseArray(String value) {
		return parseArray(value, "\\|");
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Date 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param Date defaultValue，默认值
	 * 
	 * @return Date，结果
	 */
	public static Date tryToDate(Object input, Date defaultValue) {
		ArrayList<String> formats = new ArrayList<String>();
		formats.add("yyyy-MM-dd HH:mm:ss.SSS");
		formats.add("yyyy-MM-dd HH:mm:ss");
		formats.add("yyyy-MM-dd");
		formats.add("yyyy/MM/dd HH:mm:ss.SSS");
		formats.add("yyyy/MM/dd HH:mm:ss");
		formats.add("yyyy/MM/dd");
		formats.add("yyyy-M-d H:m:ss.SSS");
		formats.add("yyyy-M-d H:m:ss");
		formats.add("yyyy-M-d");
		formats.add("yyyy/M/d H:m:ss.SSS");
		formats.add("yyyy/M/d H:m:ss");
		formats.add("yyyy/M/d");

		for (String format : formats) {
			try {
				SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
						format);
				return simpleDateFormat1.parse(input.toString());
			} catch (Exception exception) {

			}
		}
		return defaultValue;
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Date 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param Date defaultValue，默认值
	 * 
	 * @return Date，结果
	 */
	@SuppressWarnings("deprecation")
	public static Date tryToDate(Object input) {
		return tryToDate(input, new Date(1900, 1, 1));
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Integer 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param int defaultValue，默认值
	 * 
	 * @return int，结果
	 */
	public static int tryToInteger(Object input, int defaultValue) {
		try {
			return Integer.parseInt(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Integer 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param int defaultValue，默认值
	 * 
	 * @return int，结果
	 */
	public static int tryToInteger(Object input) {
		return tryToInteger(input, (int) 0);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Short 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param short defaultValue，默认值
	 * 
	 * @return short，结果
	 */
	public static short tryToShort(Object input, short defaultValue) {
		try {
			return Short.parseShort(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Short 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param short defaultValue，默认值
	 * 
	 * @return short，结果
	 */
	public static short tryToShort(Object input) {
		return tryToShort(input, (short) 0);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Long 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param long defaultValue，默认值
	 * 
	 * @return long，结果
	 */
	public static long tryToLong(Object input, long defaultValue) {
		try {
			return Long.parseLong(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Long 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param long defaultValue，默认值
	 * 
	 * @return long，结果
	 */
	public static long tryToLong(Object input) {
		return tryToLong(input, (long) 0);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Double 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param double defaultValue，默认值
	 * 
	 * @return double，结果
	 */
	public static double tryToDouble(Object input, double defaultValue) {
		try {
			return Double.parseDouble(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Double 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param double defaultValue，默认值
	 * 
	 * @return double，结果
	 */
	public static double tryToDouble(Object input) {
		return tryToDouble(input, (double) 0);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 String 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param String defaultValue，默认值
	 * 
	 * @return String，结果
	 */
	public static String tryToString(Object input, String defaultValue) {
		try {
			return input.toString();
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 String 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param String defaultValue，默认值
	 * 
	 * @return String，结果
	 */
	public static String tryToString(Object input) {
		return tryToString(input, "NULL");
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Char 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param char defaultValue，默认值
	 * 
	 * @return char，结果
	 */
	public static char tryToChar(Object input, char defaultValue) {
		try {
			return input.toString().charAt(0);
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Char 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param char defaultValue，默认值
	 * 
	 * @return char，结果
	 */
	public static char tryToChar(Object input) {
		return tryToChar(input, 'N');
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Boolean 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param boolean defaultValue，默认值
	 * 
	 * @return boolean，结果
	 */
	public static boolean tryToBoolean(Object input, boolean defaultValue) {
		try {
			return Boolean.parseBoolean(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Boolean 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param boolean defaultValue，默认值
	 * 
	 * @return boolean，结果
	 */
	public static boolean tryToBoolean(Object input) {
		return tryToBoolean(input, false);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Byte 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param byte defaultValue，默认值
	 * 
	 * @return byte，结果
	 */
	public static byte tryToByte(Object input, byte defaultValue) {
		try {
			return Byte.parseByte(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Byte 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param byte defaultValue，默认值
	 * 
	 * @return byte，结果
	 */
	public static byte tryToByte(Object input) {
		return tryToByte(input, (byte) 0);
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Float 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param float defaultValue，默认值
	 * 
	 * @return float，结果
	 */
	public static float tryToFloat(Object input, float defaultValue) {
		try {
			return Float.parseFloat(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * 尝试转换（失败则返回默认值）-- 转换为 Float 类型
	 * 
	 * @param Object input，输入
	 * 
	 * @param float defaultValue，默认值
	 * 
	 * @return float，结果
	 */
	public static float tryToFloat(Object input) {
		return tryToFloat(input, 0);
	}

	/*
	 * 首字母大写
	 * 
	 * @param String input，输入
	 * 
	 * @return String，结果
	 */
	public static String toTitleCase(String input) {
		if (input == null || input.trim().isEmpty()) {
			return "";
		}
		char[] original = input.toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < original.length; i++) {
			if (i == 0) {
				sb.append(String.valueOf(original[i]).toUpperCase());
			} else {
				sb.append(String.valueOf(original[i]));
			}
		}
		return sb.toString();
	}
}
