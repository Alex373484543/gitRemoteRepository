package fanglab.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import fanglab.framework.security.SlDes;
import fanglab.framework.text.SlHex;

/*
 * 多用于服务端的接口调用验证
 */
public class SlToken {
	private static String skey = "76d027cb";

	/*
	 * 获取token
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
	 * 校验token
	 * 
	 * @param String token，要校验的token
	 * 
	 * @param int timeout，失效期限（秒）
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
