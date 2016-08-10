package fanglab.framework;

/*
 * �ַ���
 */
public class SlString {

	/**
	 * �Ƿ�Ϊ��
	 * 
	 * @param input
	 *            ������
	 * @return�����
	 */
	public static boolean isNullOrWhiteSpace(String input) {
		return input == null || input.length() == 0
				|| input.replace(" ", "").length() == 0;
	}

	/**
	 * �Ƿ�Ϊ��
	 * 
	 * @param input
	 *            ������
	 * @return�����
	 */
	public static boolean isNullOrEmpty(String input) {
		return input == null || input.length() == 0;
	}

	/*
	 * ��ȡ��벿��
	 * 
	 * @param String input������
	 * 
	 * @param int length������
	 * 
	 * @param String ex����չ�ַ�
	 * 
	 * @return String�����
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
	 * ��ȡ��벿��
	 * 
	 * @param String input������
	 * 
	 * @param int length������
	 * 
	 * @param String ex����չ�ַ�
	 * 
	 * @return String�����
	 */
	public static String left(String input, int length) {
		return left(input, length, "...");
	}

	/*
	 * �Ƿ�ȫΪ�գ�ֻҪ��һ����Ϊ�գ��򷵻�false��
	 * 
	 * @param String...input������
	 * 
	 * @return Boolean�����
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
	 * �Ƿ���һ��Ϊ�գ�ֻҪ��һ��Ϊ�գ��򷵻�true��
	 * 
	 * @param String...input������
	 * 
	 * @return Boolean�����
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
