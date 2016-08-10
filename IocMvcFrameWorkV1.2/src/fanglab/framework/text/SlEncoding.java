package fanglab.framework.text;

/*
 * 编码
 */
public class SlEncoding {
	// 默认编码
	public static String Default = "utf8";

	/*
	 * 转换Iso8859为GB2312
	 * 
	 * @param String input，输入
	 * 
	 * @return String，结果
	 */
	public static String convertIso8859ToGB2312(String input) {
		try {
			return new String(input.getBytes("iso8859-1"), "gb2312");
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 转换GB2312为Iso8859
	 * 
	 * @param String input，输入
	 * 
	 * @return String，结果
	 */
	public static String convertGB2312ToIso8859(String input) {
		try {
			return new String(input.getBytes("gb2312"), "iso8859-1");
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}
}
