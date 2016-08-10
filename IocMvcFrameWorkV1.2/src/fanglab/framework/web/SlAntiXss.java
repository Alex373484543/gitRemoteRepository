package fanglab.framework.web;

import java.util.regex.*;

public class SlAntiXss {

	/*
	 * 非法字符串过滤
	 */
	public static String getSafeHtml(String value) {
		if (value != null) {
			value = value.replaceAll("", "");
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("javascript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("vbscript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}

	/*
	 * 获取过滤后的文本
	 */
	public static String getSafeText(String input) {
		return input.replaceAll("<[^>]*>", "");
	}
}
