package fanglab.framework.net;

import java.io.*;
import java.net.*;

public class SlSocket {
	/*
	 * 发送信息
	 * 
	 * @param String ip，ip
	 * 
	 * @param int port，端口
	 * 
	 * @param String message，消息
	 * 
	 * @param boolean flgReceive，是否接受消息
	 * 
	 * @param String encoding，数据编码方式
	 * 
	 * @return String，结果
	 */
	public static String send(String ip, int port, String message,
			boolean flgReceive, String encoding) {
		try {
			String result = "";
			Socket handler = new Socket(ip, port);
			handler.setSendBufferSize(Integer.MAX_VALUE);
			handler.setSoTimeout(0);
			handler.setReceiveBufferSize(Integer.MAX_VALUE);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					handler.getOutputStream(), encoding);
			outputStreamWriter.write(message);
			outputStreamWriter.flush();
			if (!flgReceive) {
				handler.shutdownInput();
				handler.shutdownOutput();
				handler.close();
				return result;
			}
			InputStreamReader inputStreamReader = new InputStreamReader(
					handler.getInputStream());
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int current = -1;
			while ((current = inputStreamReader.read()) != -1) {
				byteArrayOutputStream.write(current);
			}
			result = byteArrayOutputStream.toString(encoding);
			handler.shutdownInput();
			handler.shutdownOutput();
			handler.close();
			return result;
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 发送信息
	 * 
	 * @param String ip，ip
	 * 
	 * @param int port，端口
	 * 
	 * @param String message，消息
	 * 
	 * @param boolean flgReceive，是否接受消息
	 * 
	 * @param String encoding，数据编码方式
	 * 
	 * @return String，结果
	 */
	public static String send(String ip, int port, String message,
			boolean flgReceive) {
		return send(ip, port, message, flgReceive, "utf8");
	}

	/*
	 * 发送信息
	 * 
	 * @param String ip，ip
	 * 
	 * @param int port，端口
	 * 
	 * @param String message，消息
	 * 
	 * @param boolean flgReceive，是否接受消息
	 * 
	 * @param String encoding，数据编码方式
	 * 
	 * @return String，结果
	 */
	public static String send(String ip, int port, String message) {
		return send(ip, port, message, false, "utf8");
	}

	/*
	 * 监听
	 * 
	 * @param String ip，IP
	 * 
	 * @param int port，端口
	 * 
	 * @param ISlSocketListenHandler func，处理器
	 */
	public static void listen(int port, ISlSocketListenHandler func) {
		try {

			ServerSocket listener = new ServerSocket(port);
			try {
				while (true) {
					Socket handler = listener.accept();
					handler.setSendBufferSize(Integer.MAX_VALUE);
					handler.setSoTimeout(0);
					handler.setReceiveBufferSize(Integer.MAX_VALUE);
					String input = "";
					InputStreamReader inputStreamReader = new InputStreamReader(
							handler.getInputStream(), "utf8");
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int current = -1;
					while ((current = inputStreamReader.read()) != -1) {
						byteArrayOutputStream.write(current);
					}
					input = byteArrayOutputStream.toString();
					String output = func.handle(input, handler);

					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
							handler.getOutputStream(), "utf8");
					outputStreamWriter.write(output);
					outputStreamWriter.flush();

					handler.shutdownInput();
					handler.shutdownOutput();
					handler.close();
				}
			} finally {
				listener.close();
			}
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}
}
