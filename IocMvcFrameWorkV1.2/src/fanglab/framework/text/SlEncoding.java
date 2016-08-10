package fanglab.framework.text;

/*
 * ����
 */
public class SlEncoding {
	// Ĭ�ϱ���
	public static String Default = "utf8";

	/*
	 * ת��Iso8859ΪGB2312
	 * 
	 * @param String input������
	 * 
	 * @return String�����
	 */
	public static String convertIso8859ToGB2312(String input) {
		try {
			return new String(input.getBytes("iso8859-1"), "gb2312");
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * ת��GB2312ΪIso8859
	 * 
	 * @param String input������
	 * 
	 * @return String�����
	 */
	public static String convertGB2312ToIso8859(String input) {
		try {
			return new String(input.getBytes("gb2312"), "iso8859-1");
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}
}
