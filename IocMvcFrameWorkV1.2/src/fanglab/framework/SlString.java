package fanglab.framework;

/*
 * 字符串
 */
public class SlString {

	/**
	 * 是否为空
	 * 
	 * @param input
	 *            ，输入
	 * @return，结果
	 */
	public static boolean isNullOrWhiteSpace(String input) {
		return input == null || input.length() == 0
				|| input.replace(" ", "").length() == 0;
	}

	/**
	 * 是否为空
	 * 
	 * @param input
	 *            ，输入
	 * @return，结果
	 */
	public static boolean isNullOrEmpty(String input) {
		return input == null || input.length() == 0;
	}

	/*
	 * 截取左半部分
	 * 
	 * @param String input，输入
	 * 
	 * @param int length，长度
	 * 
	 * @param String ex，扩展字符
	 * 
	 * @return String，结果
	 */
	public static String left(String input, int length, String ex) {
		if (input.isEmpty()) {
			return "";
		}
		if (input.length() > length) {
			return input.substring(0, length) + ex;
		} else {
			return input;
		}
	}

	/*
	 * 截取左半部分
	 * 
	 * @param String input，输入
	 * 
	 * @param int length，长度
	 * 
	 * @param String ex，扩展字符
	 * 
	 * @return String，结果
	 */
	public static String left(String input, int length) {
		return left(input, length, "...");
	}

	/*
	 * 是否全为空（只要有一个不为空，则返回false）
	 * 
	 * @param String...input，输入
	 * 
	 * @return Boolean，结果
	 */
	public static Boolean isNullOrEmptyAll(String... input) {
		for (String one : input) {
			if (!(one == null || one.isEmpty())) {
				return false;
			}
		}

		return true;
	}

	/*
	 * 是否有一个为空（只要有一个为空，则返回true）
	 * 
	 * @param String...input，输入
	 * 
	 * @return Boolean，结果
	 */
	public static Boolean isNullOrEmptyAny(String... input) {
		for (String one : input) {
			if ((one == null || one.isEmpty())) {
				return true;
			}
		}

		return false;
	}
}
