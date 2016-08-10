package fanglab.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import fanglab.framework.security.SlDes;
import fanglab.framework.text.SlHex;

/*
 * �����ڷ���˵Ľӿڵ�����֤
 */
public class SlToken {
	private static String skey = "76d027cb";

	/*
	 * ��ȡtoken
	 */
	public static String getToken() {
		String content = String.format("%s^%s^%s^%s", SlGuid.newGuid(),
				SlDateTime.now(), "Web.SlRequest.UserHostAddress",
				"HttpContext.Current.Request.UserAgent");
		return SlHex.toHex(SlDes.encrypt(content, skey), "utf8");
	}

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");

	/*
	 * У��token
	 * 
	 * @param String token��ҪУ���token
	 * 
	 * @param int timeout��ʧЧ���ޣ��룩
	 */
	public static boolean isVerifyToken(String token, int timeout) {
		try {
			token = SlHex.fromHex(token, "utf8");
			String[] values = SlDes.decrypt(token, skey).split("\\^");

			if (new Date(simpleDateFormat.parse(values[1]).getTime() + timeout
					* 1000).before(simpleDateFormat.parse(SlDateTime.now()))
					|| !values[2].equals("Web.SlRequest.UserHostAddress")
					|| !values[3]
							.equals("HttpContext.Current.Request.UserAgent")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception err) {
			return false;
		}
	}
}
