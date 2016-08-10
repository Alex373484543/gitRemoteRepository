package fanglab.framework.text;

import org.apache.commons.codec.binary.*;

/*
 * SlBase64����
 */
public class SlBase64 {
	/*
	 * ת��ΪBase64
	 * 
	 * @param String input����ת�����ַ���
	 * 
	 * @param String encoding�����뷽ʽ
	 * 
	 * @return String��ת���Ľ��
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
	 * ת��ΪBase64
	 * 
	 * @param String input����ת�����ַ���
	 * 
	 * @param String encoding�����뷽ʽ
	 * 
	 * @return String��ת���Ľ��
	 */
	public static String toBase64String(String input) {
		return toBase64String(input, "utf8");
	}

	/*
	 * ת����ԭ��ʽ
	 * 
	 * @param String input����ת�����ַ���
	 * 
	 * @param String encoding�����뷽ʽ
	 * 
	 * @return String��ת���Ľ��
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
	 * ת����ԭ��ʽ
	 * 
	 * @param String input����ת�����ַ���
	 * 
	 * @param String encoding�����뷽ʽ
	 * 
	 * @return String��ת���Ľ��
	 */
	public static String fromBase64String(String input) {
		return fromBase64String(input, "utf8");
	}
}
