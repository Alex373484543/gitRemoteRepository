package fanglab.framework;

import java.text.SimpleDateFormat;
import java.util.*;


/*
 * ת����
 */
public class SlConvert {

	/*
	 * ����Ϊ����
	 * 
	 * @param String value��ֵ
	 * 
	 * @param String split���ָ��
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
	 * ����Ϊ����
	 * 
	 * @param String value��ֵ
	 * 
	 * @param String split���ָ��
	 */
	public static <T> ArrayList<T> parseArray(String value) {
		return parseArray(value, "\\|");
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Date ����
	 * 
	 * @param Object input������
	 * 
	 * @param Date defaultValue��Ĭ��ֵ
	 * 
	 * @return Date�����
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
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Date ����
	 * 
	 * @param Object input������
	 * 
	 * @param Date defaultValue��Ĭ��ֵ
	 * 
	 * @return Date�����
	 */
	@SuppressWarnings("deprecation")
	public static Date tryToDate(Object input) {
		return tryToDate(input, new Date(1900, 1, 1));
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Integer ����
	 * 
	 * @param Object input������
	 * 
	 * @param int defaultValue��Ĭ��ֵ
	 * 
	 * @return int�����
	 */
	public static int tryToInteger(Object input, int defaultValue) {
		try {
			return Integer.parseInt(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Integer ����
	 * 
	 * @param Object input������
	 * 
	 * @param int defaultValue��Ĭ��ֵ
	 * 
	 * @return int�����
	 */
	public static int tryToInteger(Object input) {
		return tryToInteger(input, (int) 0);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Short ����
	 * 
	 * @param Object input������
	 * 
	 * @param short defaultValue��Ĭ��ֵ
	 * 
	 * @return short�����
	 */
	public static short tryToShort(Object input, short defaultValue) {
		try {
			return Short.parseShort(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Short ����
	 * 
	 * @param Object input������
	 * 
	 * @param short defaultValue��Ĭ��ֵ
	 * 
	 * @return short�����
	 */
	public static short tryToShort(Object input) {
		return tryToShort(input, (short) 0);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Long ����
	 * 
	 * @param Object input������
	 * 
	 * @param long defaultValue��Ĭ��ֵ
	 * 
	 * @return long�����
	 */
	public static long tryToLong(Object input, long defaultValue) {
		try {
			return Long.parseLong(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Long ����
	 * 
	 * @param Object input������
	 * 
	 * @param long defaultValue��Ĭ��ֵ
	 * 
	 * @return long�����
	 */
	public static long tryToLong(Object input) {
		return tryToLong(input, (long) 0);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Double ����
	 * 
	 * @param Object input������
	 * 
	 * @param double defaultValue��Ĭ��ֵ
	 * 
	 * @return double�����
	 */
	public static double tryToDouble(Object input, double defaultValue) {
		try {
			return Double.parseDouble(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Double ����
	 * 
	 * @param Object input������
	 * 
	 * @param double defaultValue��Ĭ��ֵ
	 * 
	 * @return double�����
	 */
	public static double tryToDouble(Object input) {
		return tryToDouble(input, (double) 0);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ String ����
	 * 
	 * @param Object input������
	 * 
	 * @param String defaultValue��Ĭ��ֵ
	 * 
	 * @return String�����
	 */
	public static String tryToString(Object input, String defaultValue) {
		try {
			return input.toString();
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ String ����
	 * 
	 * @param Object input������
	 * 
	 * @param String defaultValue��Ĭ��ֵ
	 * 
	 * @return String�����
	 */
	public static String tryToString(Object input) {
		return tryToString(input, "NULL");
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Char ����
	 * 
	 * @param Object input������
	 * 
	 * @param char defaultValue��Ĭ��ֵ
	 * 
	 * @return char�����
	 */
	public static char tryToChar(Object input, char defaultValue) {
		try {
			return input.toString().charAt(0);
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Char ����
	 * 
	 * @param Object input������
	 * 
	 * @param char defaultValue��Ĭ��ֵ
	 * 
	 * @return char�����
	 */
	public static char tryToChar(Object input) {
		return tryToChar(input, 'N');
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Boolean ����
	 * 
	 * @param Object input������
	 * 
	 * @param boolean defaultValue��Ĭ��ֵ
	 * 
	 * @return boolean�����
	 */
	public static boolean tryToBoolean(Object input, boolean defaultValue) {
		try {
			return Boolean.parseBoolean(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Boolean ����
	 * 
	 * @param Object input������
	 * 
	 * @param boolean defaultValue��Ĭ��ֵ
	 * 
	 * @return boolean�����
	 */
	public static boolean tryToBoolean(Object input) {
		return tryToBoolean(input, false);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Byte ����
	 * 
	 * @param Object input������
	 * 
	 * @param byte defaultValue��Ĭ��ֵ
	 * 
	 * @return byte�����
	 */
	public static byte tryToByte(Object input, byte defaultValue) {
		try {
			return Byte.parseByte(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Byte ����
	 * 
	 * @param Object input������
	 * 
	 * @param byte defaultValue��Ĭ��ֵ
	 * 
	 * @return byte�����
	 */
	public static byte tryToByte(Object input) {
		return tryToByte(input, (byte) 0);
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Float ����
	 * 
	 * @param Object input������
	 * 
	 * @param float defaultValue��Ĭ��ֵ
	 * 
	 * @return float�����
	 */
	public static float tryToFloat(Object input, float defaultValue) {
		try {
			return Float.parseFloat(input.toString());
		} catch (Exception exception) {
			return defaultValue;
		}
	}

	/*
	 * ����ת����ʧ���򷵻�Ĭ��ֵ��-- ת��Ϊ Float ����
	 * 
	 * @param Object input������
	 * 
	 * @param float defaultValue��Ĭ��ֵ
	 * 
	 * @return float�����
	 */
	public static float tryToFloat(Object input) {
		return tryToFloat(input, 0);
	}

	/*
	 * ����ĸ��д
	 * 
	 * @param String input������
	 * 
	 * @return String�����
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
