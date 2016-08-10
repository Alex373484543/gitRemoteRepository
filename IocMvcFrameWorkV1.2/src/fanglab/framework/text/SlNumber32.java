package fanglab.framework.text;

import java.util.HashMap;

import fanglab.framework.SlRef;

/*
 * 整数与32进制间的转换
 */
public class SlNumber32 {
	// 0-31 对应32个字符
	private static final String zipMapWords = "0123456789abcdefghjklmnpqrtuvwxy";

	// 整数与32进制 对照字典
	private static final HashMap<String, String> dictNumberTo32 = new HashMap<String, String>();

	// 32进制与整数 对照字典
	private static final HashMap<String, String> dict32ToNumber = new HashMap<String, String>();

	// 初始化字典
	static {
		int i = 0;
		String key = "", value = "";
		for (char item : zipMapWords.toCharArray()) {
			key = String.valueOf(i);
			value = String.valueOf(item);
			// 压缩\反压缩字典key-value相反,以实现快速查找.
			dictNumberTo32.put(key, value);
			dict32ToNumber.put(value, key);
			i++;
		}
	}

	/*
	 * 整数转为32进制
	 * 
	 * @param long theNumber，要转换的整数
	 */
	public static String convertTo32(long theNumber) {
		SlRef<String> num32 = new SlRef<String>("");
		convertTo32(theNumber, num32);
		return num32.toString();
	}

	private static void convertTo32(long theNumber, SlRef<String> num32) {
		long temp;
		temp = theNumber % 32;
		num32.set(chang(temp) + num32.get());
		if (0 != theNumber / 32) {
			convertTo32(theNumber / 32, num32);
		}
	}

	/*
	 * 整数对应的32进制值
	 */
	private static String chang(long number) {
		try {
			return dictNumberTo32.get(String.valueOf(number));
		} catch (Exception err) {
		}
		return String.valueOf(number);
	}

	/*
	 * 32进制转为整数
	 * 
	 * @param String the32Data，32进制
	 */
	public static long convertToNumber(String the32Data) {
		long result = 0;
		try {
			the32Data = the32Data.toLowerCase();
			int i = 0;
			for (char item : the32Data.toCharArray()) {
				result += Integer.parseInt(dict32ToNumber.get(String
						.valueOf(item)))
						* (long) Math.pow(32, the32Data.length() - i - 1);
				i++;
			}
		} catch (Exception err) {
		}
		return result;
	}
}
