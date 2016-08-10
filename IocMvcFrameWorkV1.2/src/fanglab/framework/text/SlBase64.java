package fanglab.framework.text;

import org.apache.commons.codec.binary.*;

/*
 * SlBase64处理
 */
public class SlBase64 {
	/*
	 * 转换为Base64
	 * 
	 * @param String input，待转换的字符串
	 * 
	 * @param String encoding，编码方式
	 * 
	 * @return String，转换的结果
	 */
	public static String toBase64String(String input, String encoding) {
		try {
			return new String(Base64.encodeBase64(input.getBytes(encoding)),
					encoding);
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 转换为Base64
	 * 
	 * @param String input，待转换的字符串
	 * 
	 * @param String encoding，编码方式
	 * 
	 * @return String，转换的结果
	 */
	public static String toBase64String(String input) {
		return toBase64String(input, "utf8");
	}

	/*
	 * 转换回原形式
	 * 
	 * @param String input，待转换的字符串
	 * 
	 * @param String encoding，编码方式
	 * 
	 * @return String，转换的结果
	 */
	public static String fromBase64String(String input, String encoding) {
		try {
			return new String(Base64.decodeBase64(input.getBytes(encoding)),
					encoding);
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 转换回原形式
	 * 
	 * @param String input，待转换的字符串
	 * 
	 * @param String encoding，编码方式
	 * 
	 * @return String，转换的结果
	 */
	public static String fromBase64String(String input) {
		return fromBase64String(input, "utf8");
	}
}
