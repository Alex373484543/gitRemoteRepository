package fanglab.framework;

import java.text.*;
import java.util.regex.*;

/*
 * ��֤
 */
public class SlValidation {

	/*
	 * �Ƿ��ǵ����ȸ�����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ���˫���ȸ�����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ���32λ����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ���16λ����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ���64λ����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ����ַ�����
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ���ʱ��
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
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
	 * �Ƿ�������
	 * 
	 * @param String input������
	 * 
	 * @return boolean�����
	 */
	public static boolean isEmail(String input) {
		Pattern pattern = Pattern.compile(
				"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
