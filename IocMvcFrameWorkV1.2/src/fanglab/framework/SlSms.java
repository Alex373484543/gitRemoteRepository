package fanglab.framework;

import java.net.URLEncoder;

import fanglab.framework.web.SlJson;
import fanglab.framework.web.SlRequest;

/*
 * 发送短信报警
 */
public class SlSms {
	// 短信接口地址
	private final static String smsUrl = "http://smss.interface.light.soufun.com:8080/sendsms.php?mobie=%s&content=%s";

	/*
	 * 发送短信
	 * 
	 * @param String phone，手机号码
	 * 
	 * @param String message，发送消息（自动截断为70个字符进行分段发送，message支持自动空格转换为下划线）
	 */
	public static void send(String phone, String message) {
		message = message.replace(" ", "_");
		int index = 0;
		while (index < message.length()) {
			String current = "";
			if (index + 70 > message.length()) {
				current = message.substring(index, message.length() - index);
			} else {
				current = message.substring(index, 70);
			}
			String sendMessage = null;
			try {
				sendMessage = URLEncoder.encode(current, "GBK");
			} catch (Exception err) {
			}
			String html = SlRequest.getHtml(String.format(smsUrl, phone,
					sendMessage, "GBK"));
			SlSmsStatus smsStatus = (SlSmsStatus) SlJson.fromJson(html,
					SlSmsStatus.class);
			if (!smsStatus.getStatus().equals("0000")) {
				throw new RuntimeException("发送失败！");
			}
			index = index + 70;
		}

	}

	/*
	 * 发送短信
	 * 
	 * @param String phones，手机号码组
	 * 
	 * @param String message，发送消息（自动截断为70个字符进行分段发送，message支持自动空格转换为下划线）
	 */
	public static void send(String[] phones, String message) {
		for (String phone : phones) {
			send(phone, message);
		}
	}

	public static class SlSmsStatus {
		public String status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
