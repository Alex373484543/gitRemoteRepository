package fanglab.framework.io;

import java.io.*;

public class SlDirectory {
	/*
	 * 删除文件
	 * 
	 * @param String directory，目录
	 */
	public static void deleteFiles(String directory) {
		try {
			File file = new File(directory);

			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					try {
						files[i].delete();
					} catch (Exception err) {
					}
				}
			}
		} catch (Exception err) {
		}
	}

	/**
	 * 判断是不是存在
	 * 
	 * @param directory
	 *            ，目录
	 * @return，结果
	 */
	public static boolean exists(String directory) {
		return new File(directory).exists();
	}

	/**
	 * 获得文件列表
	 * 
	 * @param directory
	 *            ，目录
	 * @return，结果
	 */
	public static String[] getFiles(String directory) {
		File[] files = new File(directory).listFiles();
		String[] result = new String[files.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = files[i].getAbsolutePath();
		}
		return result;
	}
}
