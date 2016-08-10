package fanglab.framework.io;

import java.io.*;
import java.util.zip.*;


public class SlFile {
	/*
	 * 写入日志
	 * 
	 * @param String filePath，文件路径，文件不存在时会自动创建，存在时则追加信息
	 * 
	 * @param String message，写入内容
	 * 
	 * @param String isNewline，是否自动换行
	 * 
	 * @param String append，是否在当前文本后附加,替换
	 * 
	 * @param String encoding，编码方式
	 */
	public static void write(String filePath, String message,
			boolean isNewline, String encoding, boolean append) {
		try {
			File file = new File(filePath);
			file.getParentFile().mkdirs();
		} catch (Exception err) {
		}
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		try {
			fileOutputStream = new FileOutputStream(new File(filePath), append);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,
					encoding);

			if (isNewline) {
				outputStreamWriter.write(message);
				outputStreamWriter.write(System.getProperty("line.separator"));
			} else {
				outputStreamWriter.write(message);
			}
			outputStreamWriter.flush();
		} catch (Exception err) {
		} finally {
			try {
				outputStreamWriter.close();
			} catch (IOException e) {

			}
			try {
				fileOutputStream.close();
			} catch (IOException e) {

			}
		}
	}

	/*
	 * 写入日志
	 * 
	 * @param String filePath，文件路径，文件不存在时会自动创建，存在时则追加信息
	 * 
	 * @param String message，写入内容
	 * 
	 * @param String isNewline，是否自动换行
	 * 
	 * @param String append，是否在当前文本后附加,替换
	 * 
	 * @param String encoding，编码方式
	 */
	public static void write(String filePath, String message,
			boolean isNewline, String encoding) {
		write(filePath, message, isNewline, encoding, true);
	}

	/*
	 * 写入日志
	 * 
	 * @param String filePath，文件路径，文件不存在时会自动创建，存在时则追加信息
	 * 
	 * @param String message，写入内容
	 * 
	 * @param String isNewline，是否自动换行
	 * 
	 * @param String append，是否在当前文本后附加,替换
	 * 
	 * @param String encoding，编码方式
	 */
	public static void write(String filePath, String message, boolean isNewline) {
		write(filePath, message, isNewline, "utf8", true);
	}

	/*
	 * 写入日志
	 * 
	 * @param String filePath，文件路径，文件不存在时会自动创建，存在时则追加信息
	 * 
	 * @param String message，写入内容
	 * 
	 * @param String isNewline，是否自动换行
	 * 
	 * @param String append，是否在当前文本后附加,替换
	 * 
	 * @param String encoding，编码方式
	 */
	public static void write(String filePath, String message) {
		write(filePath, message, true, "utf8", true);
	}

	/*
	 * 获得读取流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static InputStreamReader getStreamReader(String path,
			SlFileType fileType, String fileEncoding) {

		try {
			FileInputStream fileInputStream = new FileInputStream(
					new File(path));
			if (fileType == SlFileType.GZip) {
				GZIPInputStream gzipInputStream = new GZIPInputStream(
						fileInputStream);
				return new InputStreamReader(gzipInputStream, fileEncoding);
			} else {
				return new InputStreamReader(fileInputStream, fileEncoding);
			}
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * 获得读取流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static InputStreamReader getStreamReader(String path,
			SlFileType fileType) {
		return getStreamReader(path, fileType, "utf8");
	}

	/*
	 * 获得读取流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static InputStreamReader getStreamReader(String path) {
		return getStreamReader(path, SlFileType.Text);
	}

	/*
	 * 获得写入流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static OutputStreamWriter getStreamWriter(String path,
			SlFileType fileType, String fileEncoding) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					path));
			if (fileType == SlFileType.GZip) {
				GZIPOutputStream gzipOutputStream = new GZIPOutputStream(
						fileOutputStream);
				return new OutputStreamWriter(gzipOutputStream, fileEncoding);
			} else {
				return new OutputStreamWriter(fileOutputStream, fileEncoding);
			}
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * 获得写入流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static OutputStreamWriter getStreamWriter(String path,
			SlFileType fileType) {
		return getStreamWriter(path, fileType, "utf8");
	}

	/*
	 * 获得写入流
	 * 
	 * @param String path，路径
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @param String fileEncoding，文件编码
	 * 
	 * @return，结果
	 */
	public static OutputStreamWriter getStreamWriter(String path) {
		return getStreamWriter(path, SlFileType.Text);
	}

	/*
	 * 将对象转成二进制文件存储到对应的目录
	 * 
	 * @param Object obj，对象
	 * 
	 * @param String path，文件地址
	 * 
	 * @param SlFileType fileType，文件类型
	 */
	public static void binaryWrite(Object obj, String path, SlFileType fileType) {
		File file = new File(path);
		ObjectOutputStream objectOutputStream = null;
		try {
			if (fileType == SlFileType.Text) {
				objectOutputStream = new ObjectOutputStream(
						new FileOutputStream(file));
			} else {
				objectOutputStream = new ObjectOutputStream(
						new GZIPOutputStream(new FileOutputStream(file)));
			}
			objectOutputStream.writeObject(obj);
		} catch (Exception err) {
		} finally {
			try {
				objectOutputStream.close();
			} catch (Exception err) {

			}
		}
	}

	/*
	 * 将对象转成二进制文件存储到对应的目录
	 * 
	 * @param Object obj，对象
	 * 
	 * @param String path，文件地址
	 * 
	 * @param SlFileType fileType，文件类型
	 */
	public static void binaryWrite(Object obj, String path) {
		binaryWrite(obj, path, SlFileType.Text);
	}

	/*
	 * 将二进制文件转成对象并返回
	 * 
	 * @param String path，文件地址
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @return，对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T binaryRead(String path, SlFileType fileType) {
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		ObjectInputStream objectInputStream = null;
		try {
			if (fileType == SlFileType.Text) {
				objectInputStream = new ObjectInputStream(new FileInputStream(
						file));
				Object obj = objectInputStream.readObject();
				return (T) obj;
			} else {
				objectInputStream = new ObjectInputStream(new GZIPInputStream(
						new FileInputStream(file)));
				Object obj = objectInputStream.readObject();
				return (T) obj;
			}
		} catch (Exception err) {
		} finally {
			try {
				objectInputStream.close();
			} catch (Exception err) {

			}
		}
		return null;
	}

	/*
	 * 将二进制文件转成对象并返回
	 * 
	 * @param String path，文件地址
	 * 
	 * @param SlFileType fileType，文件类型
	 * 
	 * @return，对象
	 */
	public static <T> T binaryRead(String path) {
		return binaryRead(path, SlFileType.Text);
	}

	/*
	 * 删除所有
	 * 
	 * @param File file，文件
	 */
	public static void deleteAll(File file) {
		if (file.isDirectory()) {
			String fileList[] = file.list();
			if (fileList.length == 0) {
				file.delete();
			} else {
				int size = fileList.length;
				for (int i = 0; i < size; i++) {
					String fileName = fileList[i];
					String fullPath = file.getPath() + File.separator
							+ fileName;
					File fileOrFolder = new File(fullPath);
					deleteAll(fileOrFolder);
				}
				file.delete();
			}
		} else {
			file.delete();
		}
	}

	/**
	 * 读取所有文本
	 * 
	 * @param path，路径
	 * @param fileEncoding，编码
	 * @return，结果
	 */
	public static String readAllText(String path, String fileEncoding) {

		try (FileInputStream fileInputStream = new FileInputStream(new File(
				path));
				InputStreamReader inputStreamReader = new InputStreamReader(
						fileInputStream, fileEncoding);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader)) {
			String line = null;
			StringBuilder lines = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				lines.append(line + System.getProperty("line.separator"));
			}
			return lines.toString();
		} catch (Exception err) {
			throw new RuntimeException(err);
		}
	}
}
