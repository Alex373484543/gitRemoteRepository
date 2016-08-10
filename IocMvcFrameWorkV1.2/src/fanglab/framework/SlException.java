package fanglab.framework;

import java.io.StringWriter;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringEscapeUtils;
import org.w3c.dom.*;

import fanglab.framework.web.SlJson;

/*
 * 异常信息
 */
public class SlException {
	/*
	 * 转换为Xml
	 * 
	 * @param Exception exception，异常
	 * 
	 * @return String，结果
	 */
	public static String toXml(Exception exception) {
		try {
			Document document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();
			Element root = document.createElement("Exception");
			{
				Element element = document.createElement("OccurTime");
				element.appendChild(document.createTextNode(SlDateTime.now()));
				root.appendChild(element);
			}
			{
				Element element = document.createElement("Message");
				element.appendChild(document.createTextNode(StringEscapeUtils
						.escapeHtml4(exception.getMessage())));
				root.appendChild(element);
			}
			{
				Element element = document.createElement("Source");
				element.appendChild(document.createTextNode(""));
				root.appendChild(element);
			}
			{
				StringBuilder sb = new StringBuilder();
				for (StackTraceElement element : exception.getStackTrace()) {
					sb.append(element.toString());
					sb.append(System.getProperty("line.separator"));
				}

				Element element = document.createElement("StackTrace");
				element.appendChild(document.createTextNode(StringEscapeUtils
						.escapeHtml4(sb.toString())));
				root.appendChild(element);
			}

			document.appendChild(root);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(
					writer));
			return String.format("<?xml version=\"1.0\" ?> %s", writer
					.getBuffer().toString());
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 转换为Dynamic
	 * 
	 * @param Exception exception，异常
	 * 
	 * @return String，结果
	 */
	public static String toJson(Exception exception) {
		SlExceptionToJson exceptionToJson = new SlExceptionToJson();
		exceptionToJson.setMessage(StringEscapeUtils.escapeHtml4(exception
				.getMessage()));
		exceptionToJson.setOccurTime(SlDateTime.now());
		exceptionToJson.setSource("");

		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : exception.getStackTrace()) {
			sb.append(element.toString());
			sb.append(System.getProperty("line.separator"));
		}

		exceptionToJson.setStackTrace(StringEscapeUtils.escapeHtml4(sb
				.toString()));

		return SlJson.toJson(exceptionToJson);
	}

	/*
	 * 转换为字符串
	 * 
	 * @param Exception exception，异常
	 * 
	 * @return String，结果
	 */
	public static String toString(Exception exception) {
		StringBuilder messages = new StringBuilder();
		messages.append(SlDateTime.now() + System.getProperty("line.separator"));
		messages.append(exception.getMessage()
				+ System.getProperty("line.separator"));
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : exception.getStackTrace()) {
			sb.append(element.toString());
			sb.append(System.getProperty("line.separator"));
		}
		messages.append(sb.toString());

		return messages.toString();
	}

	public static class SlExceptionToJson {
		private String occurTime;
		private String message;
		private String source;
		private String stackTrace;

		public String getOccurTime() {
			return occurTime;
		}

		public void setOccurTime(String occurTime) {
			this.occurTime = occurTime;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getStackTrace() {
			return stackTrace;
		}

		public void setStackTrace(String stackTrace) {
			this.stackTrace = stackTrace;
		}
	}
}
