package fanglab.framework;

import java.net.URLEncoder;

import fanglab.framework.web.SlJson;
import fanglab.framework.web.SlRequest;

/*
 * ���Ͷ��ű���
 */
public class SlSms {
	// ���Žӿڵ�ַ
	private final static String smsUrl = "http://smss.interface.light.soufun.com:8080/sendsms.php?mobie=%s&content=%s";

	/*
	 * ���Ͷ���
	 * 
	 * @param String phone���ֻ�����
	 * 
	 * @param String message��������Ϣ���Զ��ض�Ϊ70���ַ����зֶη��ͣ�message֧���Զ��ո�ת��Ϊ�»��ߣ�
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
				throw new RuntimeException("����ʧ�ܣ�");
			}
			index = index + 70;
		}

	}

	/*
	 * ���Ͷ���
	 * 
	 * @param String phones���ֻ�������
	 * 
	 * @param String message��������Ϣ���Զ��ض�Ϊ70���ַ����зֶη��ͣ�message֧���Զ��ո�ת��Ϊ�»��ߣ�
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
