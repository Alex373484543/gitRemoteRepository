package fanglab.framework.io;

import java.io.*;

public class SlDirectory {
	/*
	 * ɾ���ļ�
	 * 
	 * @param String directory��Ŀ¼
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
	 * �ж��ǲ��Ǵ���
	 * 
	 * @param directory
	 *            ��Ŀ¼
	 * @return�����
	 */
	public static boolean exists(String directory) {
		return new File(directory).exists();
	}

	/**
	 * ����ļ��б�
	 * 
	 * @param directory
	 *            ��Ŀ¼
	 * @return�����
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
