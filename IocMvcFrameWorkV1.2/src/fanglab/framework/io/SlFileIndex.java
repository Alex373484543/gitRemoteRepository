package fanglab.framework.io;

import java.io.*;

/*
 * 文件索引
 */
public class SlFileIndex {
	private static String generateFilePath(String directory, String key,
			String fileName) {
		char[] chars = key.toCharArray();

		String temp = "";
		for (char c : chars) {
			temp = temp + File.separator + String.valueOf(c);
		}

		if (!directory.endsWith(File.separator)) {
			directory = directory + File.separator;
		}

		return directory + temp + File.separator + fileName;
	}

	@SuppressWarnings("unused")
	private static String generateFilePath(String directory, String key) {
		return generateFilePath(directory, key, "data.txt");
	}

	/*
	 * 写
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 */
	public static void write(String directory, String key, String value,
			String fileName, String encoding) {
		String filePath = generateFilePath(directory, key, fileName);

		SlFile.write(filePath, value, false, encoding);
	}

	/*
	 * 写
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 */
	public static void write(String directory, String key, String value,
			String fileName) {
		write(directory, key, value, fileName, "utf8");
	}

	/*
	 * 写
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 */
	public static void write(String directory, String key, String value) {
		write(directory, key, value, "data.txt", "utf8");
	}

	/*
	 * 读
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 * 
	 * @return String，内容
	 */
	public static String read(String directory, String key, String fileName,
			String encoding) {
		String filePath = generateFilePath(directory, key, fileName);

		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					new FileInputStream(new File(filePath)), encoding);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			try {
				String line = null;
				StringBuilder stringBuilder = new StringBuilder();
				int i = 0;
				while ((line = bufferedReader.readLine()) != null) {
					if (i == 0) {
						stringBuilder.append(line);
					} else {
						stringBuilder.append(System
								.getProperty("line.separator") + line);
					}
					i++;
				}
				return stringBuilder.toString();
			} finally {
				bufferedReader.close();
			}
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}

	/*
	 * 读
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 * 
	 * @return String，内容
	 */
	public static String read(String directory, String key, String fileName) {
		return read(directory, key, fileName, "utf8");
	}

	/*
	 * 读
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @param String encoding，编码
	 * 
	 * @return String，内容
	 */
	public static String read(String directory, String key) {
		return read(directory, key, "data.txt", "utf8");
	}

	/*
	 * 是否存在
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @return boolean，结果
	 */
	public static boolean exists(String directory, String key, String fileName) {
		String filePath = generateFilePath(directory, key, fileName);

		return new File(filePath).exists();
	}

	/*
	 * 是否存在
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String value，值
	 * 
	 * @param String fileName，文件名
	 * 
	 * @return boolean，结果
	 */
	public static boolean exists(String directory, String key) {
		return exists(directory, key, "data.txt");
	}

	/*
	 * 删除
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String fileName，文件名
	 */
	public static void delete(String directory, String key, String fileName) {
		String filePath = generateFilePath(directory, key, fileName);

		new File(filePath).delete();
	}

	/*
	 * 删除
	 * 
	 * @param String directory，目录
	 * 
	 * @param String key，键
	 * 
	 * @param String fileName，文件名
	 */
	public static void delete(String directory, String key) {
		delete(directory, key, "data.txt");
	}

	/*
	 * 清除
	 * 
	 * @param String directory，目录
	 */
	public static void clear(String directory) {
		SlFile.deleteAll(new File(directory));
	}
}
