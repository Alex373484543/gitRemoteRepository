package fanglab.framework.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

/*
 * 请求
 */
public class SlRequest {

	/*
	 * 获取url里面的html
	 */
	public static String getHtml(String url, String encoding, int timeout,
			SlHttpActionType httpActionType, String postParameter) {
		try {
			URL realUrl = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) realUrl
					.openConnection();
			httpURLConnection.setConnectTimeout(timeout);
			httpURLConnection.setRequestProperty("Accept-Encoding",
					"gzip,deflate");
			PrintWriter printWriter = null;
			if (httpActionType == SlHttpActionType.Get) {
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.connect();
			} else {
				httpURLConnection.setDoInput(true);
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.addRequestProperty("Content-type",
						"application/x-www-form-urlencoded");

				if (postParameter != null) {
					printWriter = new PrintWriter(
							httpURLConnection.getOutputStream());
					printWriter.print(postParameter);
					printWriter.flush();
				}
			}
			BufferedReader bufferedReader = null;
			String type = httpURLConnection.getContentEncoding();
			if (type != null) {
				type = type.toLowerCase();
			}
			if ("gzip".equals(type)) {
				bufferedReader = new BufferedReader(
						new InputStreamReader(new GZIPInputStream(
								httpURLConnection.getInputStream()), encoding));
			} else if ("deflate".equals(type)) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						new DeflaterInputStream(
								httpURLConnection.getInputStream()), encoding));
			} else {
				bufferedReader = new BufferedReader(new InputStreamReader(
						httpURLConnection.getInputStream(), encoding));
			}

			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			try {
				while ((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} finally {
				bufferedReader.close();
				httpURLConnection.disconnect();
				if (printWriter != null) {
					printWriter.close();
				}
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/*
	 * 获取url里面的html
	 */
	public static String getHtml(String url, String encoding, int timeout,
			SlHttpActionType httpActionType) {
		return getHtml(url, encoding, timeout, httpActionType, null);
	}

	/*
	 * 获取url里面的html
	 */
	public static String getHtml(String url, String encoding, int timeout) {
		return getHtml(url, encoding, timeout, SlHttpActionType.Get, null);
	}

	/*
	 * 获取url里面的html
	 */
	public static String getHtml(String url, String encoding) {
		return getHtml(url, encoding, 1000, SlHttpActionType.Get, null);
	}

	/*
	 * 获取url里面的html
	 */
	public static String getHtml(String url) {
		return getHtml(url, "utf8", 1000, SlHttpActionType.Get, null);
	}
}
