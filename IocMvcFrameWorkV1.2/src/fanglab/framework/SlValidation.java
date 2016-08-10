package fanglab.framework;

import java.text.*;
import java.util.regex.*;

/*
 * 验证
 */
public class SlValidation {

	/*
	 * 是否是单精度浮点数
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isFloat(String input) {
		try {
			Float.parseFloat(input);
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是双精度浮点数
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isDouble(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是32位整数
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isInt32(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是16位整数
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isInt16(String input) {
		try {
			Short.parseShort(input);
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是64位整数
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isInt64(String input) {
		try {
			Long.parseLong(input);
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是字符类型
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isChar(String input) {
		try {
			if (input.length() != 1) {
				throw new Exception("");
			}
			new Character(input.charAt(0));
			return true;
		} catch (Exception err) {
		}

		return false;
	}

	/*
	 * 是否是时间
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isDate(String input) {
		boolean isDate = false;
		try {
			(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(input);
			isDate = true;
		} catch (Exception err) {
		}
		try {
			(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse(input);
			isDate = true;
		} catch (Exception err) {
		}
		try {
			(new SimpleDateFormat("yyyy-MM-dd")).parse(input);
			isDate = true;
		} catch (Exception err) {
		}
		try {
			(new SimpleDateFormat("yyyy/MM/dd")).parse(input);
			isDate = true;
		} catch (Exception err) {
		}
		return isDate;
	}

	/*
	 * 是否是邮箱
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，结果
	 */
	public static boolean isEmail(String input) {
		Pattern pattern = Pattern.compile(
				"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
