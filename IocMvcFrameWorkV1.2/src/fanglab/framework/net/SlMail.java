package fanglab.framework.net;

import java.io.File;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class SlMail {
	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void send(boolean isBodyHtml, String subject, String body,
			String from, String[] to, String[] cc, String[] bcc) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "false");
			props.setProperty("mail.host", "mail.soufun.com");
			props.setProperty("mail.transport.protocol", "smtp");
			Session session = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);
			if (isBodyHtml) {
				msg.setContent(body, "text/html;charset = utf8");
			} else {
				msg.setText(body);
			}

			msg.setFrom(new InternetAddress(from));
			{
				Address[] addresses = new Address[to.length];
				for (int i = 0; i < to.length; i++) {
					addresses[i] = new InternetAddress(to[i]);
				}
				msg.setRecipients(RecipientType.TO, addresses);
			}
			if (cc != null) {
				Address[] addresses = new Address[cc.length];
				for (int i = 0; i < cc.length; i++) {
					addresses[i] = new InternetAddress(cc[i]);
				}
				msg.setRecipients(RecipientType.CC, addresses);
			}
			if (bcc != null) {
				Address[] addresses = new Address[bcc.length];
				for (int i = 0; i < bcc.length; i++) {
					addresses[i] = new InternetAddress(bcc[i]);
				}
				msg.setRecipients(RecipientType.BCC, addresses);
			}
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void send(boolean isBodyHtml, String subject, String body,
			String from, String[] to, String[] cc) {
		send(isBodyHtml, subject, body, from, to, cc, null);
	}

	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void send(boolean isBodyHtml, String subject, String body,
			String from, String[] to) {
		send(isBodyHtml, subject, body, from, to, null, null);
	}

	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String[] attachFile，附件
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void sendWithAccessories(boolean isBodyHtml, String subject,
			String body, String[] attachFile, String from, String[] to,
			String[] cc, String[] bcc) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "false");
			props.setProperty("mail.host", "mail.soufun.com");
			props.setProperty("mail.transport.protocol", "smtp");
			Session session = Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);

			MimeMultipart allMultipart = new MimeMultipart();

			MimeBodyPart bodyPart = new MimeBodyPart();
			if (isBodyHtml) {
				bodyPart.setContent(body, "text/html;charset = utf8");
			} else {
				bodyPart.setText(body);
			}
			allMultipart.addBodyPart(bodyPart);

			if (attachFile != null && attachFile.length > 0) {
				for (int i = 0; i < attachFile.length; i++) {
					File file = new File(attachFile[i]);
					if (file.exists()) {
						MimeBodyPart attachPart = new MimeBodyPart();
						FileDataSource fsd = new FileDataSource(attachFile[i]);
						attachPart.setDataHandler(new DataHandler(fsd));
						attachPart.setFileName(fsd.getName());
						allMultipart.addBodyPart(attachPart);
					}
				}
			}
			msg.setContent(allMultipart);
			msg.setFrom(new InternetAddress(from));
			{
				Address[] addresses = new Address[to.length];
				for (int i = 0; i < to.length; i++) {
					addresses[i] = new InternetAddress(to[i]);
				}
				msg.setRecipients(RecipientType.TO, addresses);
			}
			if (cc != null) {
				Address[] addresses = new Address[cc.length];
				for (int i = 0; i < cc.length; i++) {
					addresses[i] = new InternetAddress(cc[i]);
				}
				msg.setRecipients(RecipientType.CC, addresses);
			}
			if (bcc != null) {
				Address[] addresses = new Address[bcc.length];
				for (int i = 0; i < bcc.length; i++) {
					addresses[i] = new InternetAddress(bcc[i]);
				}
				msg.setRecipients(RecipientType.BCC, addresses);
			}
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String[] attachFile，附件
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void sendWithAccessories(boolean isBodyHtml, String subject,
			String body, String[] attachFile, String from, String[] to,
			String[] cc) {
		sendWithAccessories(isBodyHtml, subject, body, attachFile, from, to,
				cc, null);
	}

	/*
	 * 发送邮件
	 * 
	 * @param boolean isBodyHtml，是否Html
	 * 
	 * @param String subject，标题
	 * 
	 * @param String body，内容
	 * 
	 * @param String[] attachFile，附件
	 * 
	 * @param String from，发送者
	 * 
	 * @param String to，接收者
	 * 
	 * @param String cc，抄送者
	 * 
	 * @param String bcc，秘送者
	 */
	public static void sendWithAccessories(boolean isBodyHtml, String subject,
			String body, String[] attachFile, String from, String[] to) {
		sendWithAccessories(isBodyHtml, subject, body, attachFile, from, to,
				null, null);
	}
}
